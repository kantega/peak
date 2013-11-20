package vis.servlet.websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Websocket callback for textmessages.
 * @author atlosm
 *
 */
public class ClientSocket implements WebSocketListener
{

	private final Logger logger = LoggerFactory.getLogger(ClientSocket.class.getName());

    @Override
    public void onWebSocketBinary(byte[] bytes, int i, int i2)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onWebSocketClose(int i, String s)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onWebSocketConnect(Session session)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onWebSocketError(Throwable throwable)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onWebSocketText(String s)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
