package vis.servlet.response;

import fj.F;
import fj.Unit;
import fj.data.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ResponseBuilder {

	/**
	 * Invoked when a request is made on this route's corresponding path e.g.
	 * '/hello'
	 * 
	 * Use and() to concatenate handlers:
	 * <code>
	 * ResponseHandler response = new SetResponseCode(200).and(new SetContentType("text/mustache")).and(new StringResponse("This is a string"));
	 * </code>
	 * 
	 * @param request
	 *            The request object providing information about the HTTP
	 *            request
	 * @param response
	 *            The response object providing functionality for modifying the
	 *            response
	 */
	public abstract void handle(HttpServletRequest request, HttpServletResponse response);

	public ResponseBuilder and(ResponseBuilder other) {
		return new CompositeResponseBuilder(List.list(other, this));
	}

	static class CompositeResponseBuilder extends ResponseBuilder
    {
		private final List<ResponseBuilder> handlers;

		public CompositeResponseBuilder(List<ResponseBuilder> handlers) {
			this.handlers = handlers;
		}

		@Override
		public void handle(final HttpServletRequest request, final HttpServletResponse response) {
			handlers.reverse().foreach(new F<ResponseBuilder, Unit>() {
				public Unit f(ResponseBuilder handler) {
					handler.handle(request, response);
					return Unit.unit();
				}
			});
		}

		public ResponseBuilder and(ResponseBuilder other) {
			return new CompositeResponseBuilder(handlers.cons(other));
		}
	}
}
