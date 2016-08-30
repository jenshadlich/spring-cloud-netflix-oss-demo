package de.jeha.demo.spring.cloud.netflix.oss.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jenshadlich@googlemail.com
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }

}