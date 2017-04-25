package leo.config;

import leo.dao.UserDAO;
import leo.dao.UserDAOimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserDAO getUserDao(){
        return new UserDAOimpl();
    }

}
