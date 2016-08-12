package de.jeha.spring.cloud.netlix.oss.core.product.resources;

import de.jeha.spring.cloud.netlix.oss.core.product.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jenshadlich@googlemail.com
 */
@RestController
public class ProductResource {

    @RequestMapping("/product/{id}")
    public Product getProduct(@PathVariable String id) {
        return new Product(id, "name");
    }

}
