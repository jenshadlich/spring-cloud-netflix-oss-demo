package de.jeha.spring.cloud.netlix.oss.compound.product.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Product;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.ProductCompound;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * @author jenshadlich@googlemail.com
 */
@RestController
public class ProductCompoundResource {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompoundResource.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/product/{id}")
    public ProductCompound getProductCompound(@PathVariable String id) {

        Product product = getProduct(id);
        Stock stock = getStock(id);

        final String productName = product == null ? "" : product.getName();
        final int quantity = stock == null ? -1 : stock.getQuantity();

        return new ProductCompound(id, productName, quantity);
    }

    private Product getProduct(String id) {
        ServiceInstance instance = loadBalancer.choose("core.product");
        URI uri = instance.getUri();
        final String url = uri.toString() + "/product/" + id;

        LOG.info("Get product from '{}'", url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        LOG.info("Status code: {}", response.getStatusCodeValue());

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.reader().forType(Product.class).readValue(response.getBody());
        } catch (IOException e) {
            LOG.warn("Unable to process product response", e);
        }
        return null;
    }

    private Stock getStock(String productId) {
        ServiceInstance instance = loadBalancer.choose("core.stock");
        URI uri = instance.getUri();
        final String url = uri.toString() + "/stock/" + productId;

        LOG.info("Get stock from '{}'", url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        LOG.info("Status code: {}", response.getStatusCodeValue());

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.reader().forType(Stock.class).readValue(response.getBody());
        } catch (IOException e) {
            LOG.warn("Unable to process stock response", e);
        }
        return null;
    }

}
