package de.jeha.demo.spring.cloud.netflix.oss.tracing;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author jenshadlich@googlemail.com
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {

    public static void main(String... args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

}