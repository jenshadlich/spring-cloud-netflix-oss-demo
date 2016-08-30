package de.jeha.demo.spring.cloud.netflix.oss.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author jenshadlich@googlemail.com
 */
@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class AuthServerApplication {

    public static void main(String... args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

}