package de.jeha.spring.cloud.netlix.oss.compound.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jenshadlich@googlemail.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductCompoundApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCompoundApplication.class, args);
    }

}