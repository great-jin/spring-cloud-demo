package xyz.ibudai.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

public class WebFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(WebFilter.class);

    /**
     * Filter type, set "pre" will active before trigger.
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * When have multiple filter, use order to set priority.
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * To set is enable filter, normally we will specify the effect region
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String targetPath = request.getRequestURL().toString();
        boolean enableFilter;
        try {
            URL url = new URL(targetPath);
            String path = url.getPath();
            int index = ordinalIndexOf(path, "/", 2);
            enableFilter = path.substring(index).startsWith("/api/login");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return !enableFilter;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("Send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getHeader("token");
        if (accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }

    private int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
}
