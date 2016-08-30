package de.jeha.spring.cloud.netlix.oss.api.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jenshadlich@googlemail.com
 */
public class Product {

    private final String id;
    private final String name;

    @JsonCreator
    public Product(@JsonProperty("id") String id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
