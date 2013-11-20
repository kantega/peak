package vis.servlet.request;

import javax.servlet.http.HttpServletRequest;
import vis.util.Pred;

/**
 * Interface for all requestmatchers. A requestmatcher matches an incoming request and yields a Boolean based on a check. The
 * check is up the implementation.
 *
 * @author atlosm
 */
public abstract class RequestMatcher extends Pred<HttpServletRequest>
{
    public boolean matches(HttpServletRequest request)
    {
        return f(request);
    }
}
