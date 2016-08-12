package de.jeha.spring.cloud.netlix.oss.compound.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jenshadlich@googlemail.com
 */
public class Stock {

    private final String productId;
    private final int quantity;

    @JsonCreator
    public Stock(@JsonProperty("productId") String productId,
                 @JsonProperty("quantity") int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

}
