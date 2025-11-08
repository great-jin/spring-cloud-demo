package xyz.ibudai.ms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    /**
     * The gateway is a common entrance for request
     * <p>
     * example: http://localhost:9095/client-1/api/client/getServices
     * ==> node: client-1, api: /api/client/getServices
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
