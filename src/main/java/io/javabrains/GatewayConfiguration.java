package io.javabrains;

import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

@EnableHystrix
@Configuration
@RefreshScope
public class GatewayConfiguration {
//extends SpringBootServletInitializer {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    	.route(p -> p
		    			.path("/spring-security-jwt-jpa-user-regis-rest-microservice-api/userlogin")
		    //			.filters(f -> f.hystrix(config -> config.setName("user-regis-service")))
		    //			.uri("https://user-regis-service"))
		    			.uri("lb://user-regis-service"))
		    //			.uri("https://localhost:8444"))
	    	.route(p -> p
	    			.path("/")
	       			.uri("lb://user-regis-service"))
	    	.route(p -> p
	    			.path("/users/all")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/{Id}")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/add")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/update/{Id}")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/delete/{Id}")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/forgotpassword/{Id}")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	    	.route(p -> p
	    			.path("/user/verifyOTP/{Id}")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))
	     	.route(p -> p
	    			.path("/hello")
	       			.uri("lb://user-regis-service/spring-security-jwt-jpa-user-regis-rest-microservice-api"))	
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
