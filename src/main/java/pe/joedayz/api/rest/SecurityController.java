package pe.joedayz.api.rest;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import pe.joedayz.api.domain.model.entities.ResetRegistry;
import pe.joedayz.api.domain.model.entities.User;
import pe.joedayz.api.domain.model.repository.jpa.ResetRegistryJpaRepository;
import pe.joedayz.api.domain.model.repository.jpa.UserJpaRepository;
import pe.joedayz.api.dto.JsonResult;
import pe.joedayz.api.enums.UserStatusEnum;

/**
 * Created by MATRIX-JAVA on 2/5/2016.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.host}")
    String host;

    @Value("${spring.mail.sender}")
    String sender;

    @Autowired
    private ResetRegistryJpaRepository resetRegistryJpaRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Value("${spring.mail.fromIP}")
    String hostIpAddress;

    @RequestMapping(value="/recover", method=RequestMethod.POST, produces="application/json")
    @Transactional
    public ResponseEntity<JsonResult> generateRecoverEmail(@RequestBody String usernameJson) {
        LOGGER.info("Password recovery request for user: {}", usernameJson );
        
        Map userJson = new Gson().fromJson(usernameJson, Map.class);
        
        String username = (String) userJson.get("username");
        User currentUser = userJpaRepository.findByUserName(username);

        if (currentUser == null) {
            LOGGER.warn("Invalid Username: {}", usernameJson );
            JsonResult result = new JsonResult();
            result.setDescription("Invalid username is not registered");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        if (UserStatusEnum.LOCKED == currentUser.getStatus()) {
            LOGGER.warn("Invalid User State: {}", usernameJson );
            JsonResult result = new JsonResult();
            result.setDescription("The account has been locked for security reasons. Please contact support");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        if (UserStatusEnum.INACTIVE == currentUser.getStatus()) {
            LOGGER.warn("Invalid User State: {}", usernameJson );
            JsonResult result = new JsonResult();
            result.setDescription("The account has been marked as inactive. Please contact support");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        String token = generateSecurityToken();
        ResetRegistry resetRegistry = new ResetRegistry();


        resetRegistry.setUserName(username);
        resetRegistry.setToken(token);

        ResetRegistry entity = resetRegistryJpaRepository.save(resetRegistry);

        try {
            sendEmail(token, currentUser.getEmail());
        } catch (Exception e){
            LOGGER.error("Error Sending email", e);
            JsonResult result = new JsonResult();
            result.setDescription("Error sending resend email please try again later");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        JsonResult result = new JsonResult();
        result.setDescription("Please search your inbox for the recovery link");
        LOGGER.warn("The email was sent Successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private void sendEmail(String token, String sendToEmail){
        LOGGER.info("Sending email to {}", sendToEmail);
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(sendToEmail);
            helper.setReplyTo(sender);
            helper.setFrom(sender);
            helper.setSubject("Pricing: Password Recovery Request");
            helper.setText(buildEmailTextBody(token));
        } catch (MessagingException e) {
            LOGGER.error("Error Building email body", e);
            e.printStackTrace();
        } finally {}

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("EMail host: {}", host);
        }
        javaMailSender.send(mail);
    }

    private String buildEmailTextBody(String token){
        String msg = "Please click in the following link to reset your password "
                + buildChangePasswordPageUrl(token);

        return msg;
    }

    private String buildChangePasswordPageUrl(String token){
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        UriComponents result = builder.scheme("http").host(this.hostIpAddress).path("reset-password")
                .queryParam("sectkval="+token).build();
        return result.toString();
    }

    private String generateSecurityToken(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        LOGGER.info("Generated Token: " + token);
        return token;
    }

    @RequestMapping(value="/change-password", method=RequestMethod.POST, produces="application/json")
    @Transactional
    public ResponseEntity<JsonResult> changePassword(@RequestBody String resetPasswordInfo) {

        Map resetPasswordJson = new Gson().fromJson(resetPasswordInfo, Map.class);
        String newPassword = (String)resetPasswordJson.get("confirmPassword");
        String sectkval = (String)resetPasswordJson.get("sectkval");

        LOGGER.info("Receiving password changed request for token {}", sectkval);

        //Get the user name
        ResetRegistry resetEntry = resetRegistryJpaRepository.findByToken(sectkval);

        if (resetEntry == null) {
            LOGGER.warn("Invalid User Token: {}", sectkval);
            JsonResult result = new JsonResult();
            result.setDescription("The token is invalid. Please request a new one");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }


        long startTime = new Date().getTime();
        long endTime = resetEntry.getCreatedDate().getTime();
        long minutesInMilli = 1000 * 60;
        long minutesInADay = 1440;

        long elapsedMins = (startTime - endTime)/minutesInMilli;

        if (elapsedMins > minutesInADay ){
            JsonResult result = new JsonResult();
            result.setDescription("The link you have accessed is older than a day; please use the Forgot Password link again.");
            result.setStatus("ERR");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        User user = userJpaRepository.findByUserName(resetEntry.getUserName());
        LOGGER.info("Changing password of user {}", resetEntry.getUserName());

        user.setPassword(newPassword);
        userJpaRepository.save(user);
        JsonResult result = new JsonResult();
        result.setDescription("Password Changed, please go to Login page");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
