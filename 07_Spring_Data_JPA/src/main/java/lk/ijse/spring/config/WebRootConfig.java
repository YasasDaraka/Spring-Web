package lk.ijse.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class) // Import the JPA configuration class
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("WebRootConfig");
    }
}
