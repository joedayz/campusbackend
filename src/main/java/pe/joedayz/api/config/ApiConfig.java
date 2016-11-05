package pe.joedayz.api.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApiConfig {

	
	  @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("/messages");
	        messageSource.setDefaultEncoding("UTF-8");
	        return messageSource;
	    }
	    
	    @Bean(name = "org.dozer.Mapper")
	    public DozerBeanMapper dozerBean() {
	        DozerBeanMapper dozerBean = new DozerBeanMapper();
	        return dozerBean;
	    }
	    

	    
}
