package de.jeha.spring.cloud.netlix.oss.compound.product.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import de.jeha.spring.cloud.netlix.oss.compound.product.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Future;

/**
 * @author jenshadlich@googlemail.com
 */
@Component
public class ProductDataProvider {

    private static final Logger LOG = LoggerFactory.getLogger(StockDataProvider.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * @param id product id
     * @return product
     */
    @HystrixCommand(fallbackMethod = "defaultProduct")
    public Future<Product> getProduct(String id) {
        return new AsyncResult<Product>() {
            @Override
            public Product invoke() {
                ServiceInstance instance = loadBalancer.choose("core-product");
                if (instance != null) {
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
                }
                return null;
            }
        };
    }

    public Product defaultProduct(String id) {
        return null;
    }

}
