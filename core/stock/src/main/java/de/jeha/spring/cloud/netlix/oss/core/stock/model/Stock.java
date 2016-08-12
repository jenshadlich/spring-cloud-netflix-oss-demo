package de.jeha.spring.cloud.netlix.oss.core.stock.model;

/**
 * @author jenshadlich@googlemail.com
 */
public class Stock {

    private final String productId;
    private final int quantity;

    public Stock(String productId, int quantity) {
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
