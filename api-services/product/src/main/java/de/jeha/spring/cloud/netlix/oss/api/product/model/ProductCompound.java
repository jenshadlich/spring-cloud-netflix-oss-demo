package de.jeha.spring.cloud.netlix.oss.api.product.model;

/**
 * @author jenshadlich@googlemail.com
 */
public class ProductCompound {

    private final String id;
    private final String name;
    private final int quantity;

    public ProductCompound(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

}
