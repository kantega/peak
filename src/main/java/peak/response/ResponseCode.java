package vis.servlet.response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vis.servlet.response.ResponseBuilder;

/**
 * Sets the response code in the response to the given code.
 * @author atlosm
 *
 */
public class ResponseCode extends ResponseBuilder
{

	private final int code;
	
	public ResponseCode(int code) {this.code = code;}
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(code);
	}

}
