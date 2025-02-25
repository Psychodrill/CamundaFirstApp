package camundaapp.myfirstapp.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "credentials")
//@ConfigurationPropertiesScan
public class ConfigProperties {

   private String username;
   private String password;

}