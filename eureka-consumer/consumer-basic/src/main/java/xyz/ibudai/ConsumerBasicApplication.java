package xyz.ibudai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerBasicApplication.class, args);
	}

}