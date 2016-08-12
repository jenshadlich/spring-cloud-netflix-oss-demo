package de.jeha.spring.cloud.netlix.oss.compound.product.resources;

import de.jeha.spring.cloud.netlix.oss.compound.product.data.ProductDataProvider;
import de.jeha.spring.cloud.netlix.oss.compound.product.data.StockDataProvider;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Product;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.ProductCompound;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jenshadlich@googlemail.com
 */
@RestController
public class ProductCompoundResource {

    @Autowired
    private StockDataProvider stockDataProvider;

    @Autowired
    private ProductDataProvider productDataProvider;

    @RequestMapping("/product/{id}")
    public ProductCompound getProductCompound(@PathVariable String id) {

        Product product = productDataProvider.getProduct(id);
        Stock stock = stockDataProvider.getStock(id);

        final String productName = product == null ? "" : product.getName();
        final int quantity = stock == null ? -1 : stock.getQuantity();

        return new ProductCompound(id, productName, quantity);
    }

}
