package com.example.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/v1/auth/**").uri("lb://AUTH-SERVICE"))
                .route(r -> r.path("/v1/books/**").uri("lb://CATALOG-SERVICE"))
                .route(r -> r.path("/v1/borrowers/**", "/v1/borrowings/**").uri("lb://BORROWING-SERVICE"))
                .build();
    }

}
