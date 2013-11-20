package vis.servlet.websocket;

import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet that handles websocket requests from clients.
 * @author atlosm
 *
 */
public class WebSocketHandler extends WebSocketServlet
{

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    public void configure(WebSocketServletFactory factory)
    {
       factory.setCreator(new WebSocketCreator()
       {
           @Override
           public Object createWebSocket(
                   UpgradeRequest request, UpgradeResponse response)
           {
               return new ClientSocket();
           }
       });
    }




}
