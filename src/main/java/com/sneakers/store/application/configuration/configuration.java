package com.sneakers.store.application.configuration;

import com.sneakers.store.domain.port.*;
import com.sneakers.store.domain.service.*;
import com.sneakers.store.infraestructure.adapter.SneakerAdapter;
import com.sneakers.store.infraestructure.mapper.CustomerMapper;
import com.sneakers.store.infraestructure.mapper.OrderMapper;
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
    @Bean
    public CustomerService customerServiceImpl(CustomerPort customerPort,SendEmailPort sendEmailPort){
        return new CustomerServiceImpl(customerPort,sendEmailPort);
    }

    @Bean
    public InvoiceService invoiceServiceImpl(InvoicePort invoicePort, OrderMapper orderMapper){
        return new InvoiceServiceImpl(invoicePort,orderMapper);
    }
    @Bean
    public OrderService orderServiceImpl(OrderPort orderPort,CustomerPort customerPort,CustomerMapper customerMapper,InvoiceService invoiceService){
        return new OrderServiceImpl(orderPort,customerPort,customerMapper,invoiceService);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }

}
