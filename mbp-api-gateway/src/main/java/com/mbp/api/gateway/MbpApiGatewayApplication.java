package com.mbp.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class MbpApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbpApiGatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("movie-catalog", rt -> rt.path("/idx/**")
                .uri("lb://mbp-api-movie-catalog/"))
                .build();

    }	
}
