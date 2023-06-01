package xyz.ibudai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class APIGatewayApplication {

    /**
     * The gateway is a common entrance for request
     * <p>
     * example: http://localhost:9095/client-1/api/client/dc
     * ==> node: client-1, api: /api/client/dc
     */
    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

}
