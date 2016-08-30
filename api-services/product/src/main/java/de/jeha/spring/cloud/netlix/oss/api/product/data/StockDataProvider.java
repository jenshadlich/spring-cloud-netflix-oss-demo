package de.jeha.spring.cloud.netlix.oss.api.product.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import de.jeha.spring.cloud.netlix.oss.api.product.model.Stock;
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
public class StockDataProvider {

    private static final Logger LOG = LoggerFactory.getLogger(StockDataProvider.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * @param productId product id
     * @return stock data for given product id
     */
    @HystrixCommand(fallbackMethod = "defaultStock")
    public Future<Stock> getStock(String productId) {
        return new AsyncResult<Stock>() {
            @Override
            public Stock invoke() {
                ServiceInstance instance = loadBalancer.choose("core-stock");
                if (instance != null) {
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
                }
                return null;

            }
        };
    }

    public Stock defaultStock(String productId) {
        return null;
    }

}
