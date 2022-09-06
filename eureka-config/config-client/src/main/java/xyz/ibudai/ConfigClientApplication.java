package xyz.ibudai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 激活 Eureka 中的 DiscoveryClient 实现
@EnableDiscoveryClient
public class ConfigGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigGitApplication.class, args);
	}

}
