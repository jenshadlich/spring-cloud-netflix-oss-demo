package de.jeha.demo.spring.cloud.netflix.oss.edge.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jenshadlich@googlemail.com
 */
public class LoggingPreFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingPreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        LOG.info("{} request to {}", request.getMethod(), request.getRequestURL().toString());

        return null;
    }

}
