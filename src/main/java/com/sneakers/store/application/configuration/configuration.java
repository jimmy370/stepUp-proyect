package com.sneakers.store.application.configuration;

import com.sneakers.store.domain.port.SendEmailPort;
import com.sneakers.store.domain.port.SneakersPort;
import com.sneakers.store.domain.service.SendEmailService;
import com.sneakers.store.domain.service.SendEmailServiceImpl;
import com.sneakers.store.domain.service.SneakersApi;
import com.sneakers.store.domain.service.SneakersApiImpl;
import com.sneakers.store.infraestructure.adapter.SendEmailAdapter;
import com.sneakers.store.infraestructure.adapter.SneakerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.sneakers.store.infraestructure",
        "com.sneakers.store.application",
        "com.sneakers.store.domain"
})
public class configuration implements WebMvcConfigurer {

    @Bean
    public SneakersApi sneakersApiImpl(SneakersPort sneakersPort){
        return new SneakersApiImpl(sneakersPort);
    }

    @Bean
    public SneakersPort sneakersAdapter(RestOperations restOperations){
        return new SneakerAdapter(restOperations);
    }

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public SendEmailService sendEmailServiceImpl(SendEmailPort sendEmailPort){
        return new SendEmailServiceImpl(sendEmailPort);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Aplica a todas las rutas
                .allowedOrigins("*")  // ✅ Permitir todos los orígenes
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");  // ✅ Permitir todas las cabeceras
    }

}
