package lk.ijse.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
@Import(JPAConfig.class) // Import the JPA configuration class
@ComponentScan(basePackages = "lk.ijse.spring.service")
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("WebRootConfig");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
