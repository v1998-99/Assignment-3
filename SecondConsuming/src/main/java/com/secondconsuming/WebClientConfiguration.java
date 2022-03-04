package com.secondconsuming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("http://demo5817427.mockable.io/").build();

    }
}
