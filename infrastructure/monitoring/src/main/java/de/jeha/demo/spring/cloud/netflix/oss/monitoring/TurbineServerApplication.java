package de.jeha.demo.spring.cloud.netflix.oss.monitoring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author jenshadlich@googlemail.com
 */
@SpringBootApplication
@EnableTurbine
@EnableDiscoveryClient
@EnableHystrixDashboard
public class TurbineServerApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder(TurbineServerApplication.class).web(true).run(args);
    }

}