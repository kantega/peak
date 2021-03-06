package peak.request;

import fj.F;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface for all requestmatchers. A requestmatcher matches an incoming request and yields a Boolean based on a check. The
 * check is up the implementation.
 *
 * @author atlosm
 */
public abstract class RequestMatcher implements F<HttpServletRequest,Boolean>
{
    public boolean matches(HttpServletRequest request)
    {
        return f(request);
    }
}
