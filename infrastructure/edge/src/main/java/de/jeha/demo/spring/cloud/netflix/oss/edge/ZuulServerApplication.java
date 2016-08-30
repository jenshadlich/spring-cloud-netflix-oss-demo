package de.jeha.demo.spring.cloud.netflix.oss.edge;

import de.jeha.demo.spring.cloud.netflix.oss.edge.filters.LoggingPreFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author jenshadlich@googlemail.com
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
    }

    @Bean
    public LoggingPreFilter loggingPreFilter() {
        return new LoggingPreFilter();
    }

}