package vis.servlet;

import vis.servlet.response.ResponseBuilder;

public abstract class Responder
{

    public static Responder respondWith(ResponseBuilder builder){
        return new SimpleResponse(builder);
    }

    /**
     * An application that creates a responsebuilder based on the HandlerContext, which contains the httprequest and the
     *         servletcontext.
     * @return a ResponseBuilder that mutates the HttpServletResponse
     */
    public abstract ResponseBuilder run(final HandlerContext context);

    /**
     * A simple app wrapping a responsehandler. Does not use any information in the context.
     * @author atlosm
     *
     */
    public static class SimpleResponse extends Responder
    {

        private final ResponseBuilder handler;

        public SimpleResponse(ResponseBuilder handler) {
            this.handler = handler;
        }

        @Override
        public ResponseBuilder run(HandlerContext context) {
            return handler;
        }

        @Override
        public String toString() {
            return "QuickResponse [handler=" + handler + "]";
        }

    }
}
