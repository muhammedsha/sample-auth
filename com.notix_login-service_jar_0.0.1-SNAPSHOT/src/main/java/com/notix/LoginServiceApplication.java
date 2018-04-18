package com.notix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@EnableResourceServer
public class LoginServiceApplication {
    
   // private static final Logger logger = LoggerFactory.getLogger(LoginServiceApplication.class);
    /*
    @LoadBalanced
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(
        OAuth2ClientContext oauth2ClientContext,
        OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }*/
    
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
        
}
