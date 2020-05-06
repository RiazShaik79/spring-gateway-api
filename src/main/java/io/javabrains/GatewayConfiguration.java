package io.javabrains;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    		
	    	.route(p -> p
	    			.path("/login")
	    			.filters(f -> f.addRequestHeader("Content-Type", "application/json"))
	    			.uri("http://user-auth-service/authenticate"))
	        .route(p -> p
	            .path("/get")
	            .filters(f -> f.addRequestHeader("Hello", "World"))
	            .uri("http://httpbin.org:80"))
	        .route(p -> p
	            .host("*.hystrix.com")
	            .filters(f -> f.hystrix(config -> config.setName("mycmd")))
	            .uri("http://httpbin.org:80")).
	        build();
	}
}
