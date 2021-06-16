package com.iquantex.messagecenter.endpoint;

import com.iquantex.messagecenter.common.MyWebSocketConfigurator;
import com.iquantex.messagecenter.common.SessionUtil;
import com.iquantex.web.framework.util.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息推送的Websocket 服务终端
 *
 * @author devin
 *
 */
@ServerEndpoint(value="/event/endpoint/all", configurator = MyWebSocketConfigurator.class)
@Component
public class AllEventEndpoint {
	private static final Logger LOG = LoggerFactory.getLogger(AllEventEndpoint.class);
	public static final List<Session> sessions = new ArrayList<>();

	@OnOpen
	public void handleOpen(Session session, EndpointConfig endpointConfig){

		sessions.add(session);
		LOG.info("websocket连接成功...userId:{}，sessionId:{}", SessionData.getUserId(), session.getId());
	}

	 @OnClose
	public void handleClose(Session session) {
		 sessions.remove(session);
		 LOG.info("session已关闭...userId={},sessionId:{}", getUserId(session), session.getId());

	}

	@OnError
	public void handleError(Session session, Throwable t) {
		LOG.error("handleError,sessindID:<{}>,error:<{}>", session.getId(), t.toString());
	}

	@OnMessage
	public void handleMessage(final Session session, String message) {

	}

	private Long getUserId(Session session){
		return SessionUtil.getUserId(session);
	}


}
