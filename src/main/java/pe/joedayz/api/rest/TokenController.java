package pe.joedayz.api.rest;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.joedayz.api.dto.JsonResult;
import pe.joedayz.api.repository.JdbcTokenRepositoryImpl;
import pe.joedayz.api.repository.PersistentRememberMeToken;


/**
 * Created by MATRIX-JAVA on 2/5/2016.
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init(){
        tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
    }

    private JdbcTokenRepositoryImpl tokenRepository;

    @RequestMapping(value="/createNewToken", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<JsonResult> createNewToken(@RequestBody PersistentRememberMeToken token) {
        tokenRepository.createNewToken(token);
        JsonResult result = new JsonResult();
        result.setDescription("Token generated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/updateToken", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<JsonResult> updateToken(@RequestBody PersistentRememberMeToken token) {
        tokenRepository.updateToken(token.getSeries(), token.getTokenValue(), new Date());
        JsonResult result = new JsonResult();
        result.setDescription("Token updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/getTokenForSeries", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<PersistentRememberMeToken> getTokenForSeries(@RequestBody String seriesId) {

        PersistentRememberMeToken tokenForSeries = tokenRepository.getTokenForSeries(seriesId);
        return new ResponseEntity<>(tokenForSeries, HttpStatus.OK);
    }

    @RequestMapping(value="/removeUserTokens", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<JsonResult> removeUserTokens(@RequestBody String username) {
        tokenRepository.removeUserTokens(username);
        JsonResult result = new JsonResult();
        result.setDescription("Token removed successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/getPersistentToken", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<JsonResult> getToeknByUserName(@RequestParam String username) {
        JsonResult result = new JsonResult();
        if(tokenRepository.hasPersistentToken(username)){
            result.setDescription("HasToken");
        } else {
            result.setDescription("NoToken");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
