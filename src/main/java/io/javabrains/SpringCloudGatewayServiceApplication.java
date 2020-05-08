package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayServiceApplication.class, args);
	}

}
