package vis.servlet;

import fj.F;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vis.servlet.request.Request;

/**
 * The context for the web handlers. It contains typesafe getters and setter to the servlet context, the httprequest wrapped in
 * a typesafe interface and convenience functions for getting from and setting to the context.
 *
 * @author atlosm
 */
public class HandlerContext
{
    public final HttpServletRequest request;

    private final static Logger logger = LoggerFactory.getLogger(HandlerContext.class);

    public HandlerContext(HttpServletRequest request)
    {
        this.request = request;
    }

    public <T> T get(final Class<T> c)
    {
        return HandlerContext.getFromServletContext(c, request.getServletContext());
    }

    public Request getRequest()
    {
        return new Request(request);
    }

    public static <T> F<HandlerContext, T> get_(final Class<T> c)
    {
        return new F<HandlerContext, T>()
        {
            public T f(HandlerContext ac)
            {
                return ac.get(c);
            }
        };
    }

    public static void putInServletContext(Class<?> c, Object value, ServletContext context)
    {
        context.setAttribute(c.getName(), value);
        logger.info("Setting " + c.getName() + " -> " + value);
    }

    public static <T> T getFromServletContext(Class<T> c, ServletContext sc)
    {
        logger.info("Requesting " + c.getName());
        return c.cast(sc.getAttribute(c.getName()));
    }
}
