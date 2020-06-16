package io.javabrains;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
//public class SpringCloudGatewayServiceApplication extends SpringBootServletInitializer {
public class SpringCloudGatewayServiceApplication  {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayServiceApplication.class, args);
	}
	
	/* @Bean
		public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
		    DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		    System.setProperty("javax.net.ssl.keyStore", "src/main/resources/api-gateway-cert.jks");
		    System.setProperty("javax.net.ssl.keyStorePassword", "India330$$");
		    System.setProperty("javax.net.ssl.trustStore", "src/main/resources/api-gateway-cert.jks");
		    System.setProperty("javax.net.ssl.trustStorePassword", "India330$$");
		    EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		    builder.withClientName("api-gateway-cert");
		    builder.withSystemSSLConfiguration();
		    builder.withMaxTotalConnections(10);
		    builder.withMaxConnectionsPerHost(10);
		    args.setEurekaJerseyClient(builder.build());
		    return args;
		} */
	 
	/*	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(SpringCloudGatewayServiceApplication.class); 
		} 
		
		@Bean
		public ServerCodecConfigurer serverCodecConfigurer() {
		   return ServerCodecConfigurer.create();
		}  
	*/
	   @Bean
	   public Sampler defaultSampler() {
		   return Sampler.ALWAYS_SAMPLE;
	   }

}
