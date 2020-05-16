package io.javabrains;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
@RefreshScope
public class GatewayConfiguration {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    	.route(p -> p
		    			.path("/login")
		    			.filters(f -> f.hystrix(config -> config.setName("user-regis-service")))
		    			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/users/all")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/{Id}")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/add")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/update/{Id}")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/delete/{Id}")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/forgotpassword/{Id}")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/user/verifyOTP/{Id}")
	       			.uri("lb://user-regis-service"))
	     	.route(p -> p
	    			.path("/hello")
	       			.uri("lb://user-regis-service"))	
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
