package de.jeha.spring.cloud.netlix.oss.compound.product.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author jenshadlich@googlemail.com
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
    }

}