package de.jeha.spring.cloud.netlix.oss.compound.product.resources;

import de.jeha.spring.cloud.netlix.oss.compound.product.data.ProductDataProvider;
import de.jeha.spring.cloud.netlix.oss.compound.product.data.StockDataProvider;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Product;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.ProductCompound;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author jenshadlich@googlemail.com
 */
@RestController
public class ProductCompoundResource {

    private static final Logger LOG = LoggerFactory.getLogger(StockDataProvider.class);

    @Autowired
    private StockDataProvider stockDataProvider;

    @Autowired
    private ProductDataProvider productDataProvider;

    @RequestMapping("/product/{id}")
    public ProductCompound getProductCompound(@PathVariable String id) {

        Product product = null;
        try {
            product = productDataProvider.getProduct(id).get();
        } catch (InterruptedException | ExecutionException e) {
            LOG.warn("Could not load product data", e);
        }

        Stock stock = null;
        try {
            stock = stockDataProvider.getStock(id).get();
        } catch (InterruptedException | ExecutionException e) {
            LOG.warn("Could not load stock data", e);
        }

        final String productName = product == null ? "" : product.getName();
        final int quantity = stock == null ? -1 : stock.getQuantity();

        return new ProductCompound(id, productName, quantity);
    }

}
