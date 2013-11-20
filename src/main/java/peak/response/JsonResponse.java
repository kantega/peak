package vis.servlet.response;

import fj.F;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Converts an object to JSon with the given mapper and responds the Json data as a string.
 * @author atlosm
 *
 */
public class JsonResponse<T> extends ResponseBuilder
{

	private final T value;
	private final F<T,String> mapper;
	
	public JsonResponse(T value,F<T,String> mapper) {
		this.value = value;
		this.mapper = mapper;
	}
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().print(mapper.f(value));
		} catch (IOException e) {
			// Oh no! Is this even possible? What to tell the customer? Sorry, we cannot write to your stream just now.. Oh wait, we cant write to the customer at all...
			e.printStackTrace();
		}
		
	}

}
