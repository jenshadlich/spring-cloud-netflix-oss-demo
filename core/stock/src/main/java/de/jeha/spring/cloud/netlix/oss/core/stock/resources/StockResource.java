package de.jeha.spring.cloud.netlix.oss.core.stock.resources;

import de.jeha.spring.cloud.netlix.oss.core.stock.model.Stock;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jenshadlich@googlemail.com
 */
@RestController
public class StockResource {

    @RequestMapping("/stock/{productId}")
    public Stock getStock(@PathVariable String productId) {
        return new Stock(productId, 1000);
    }

}
