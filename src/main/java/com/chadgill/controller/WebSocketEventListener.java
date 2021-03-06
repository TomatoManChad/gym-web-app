package com.chadgill.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import com.chadgill.entity.Message;
import com.chadgill.entity.User;
import com.chadgill.service.UserService;

@Component
public class WebSocketEventListener {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
		
	 @Autowired
	    private SimpMessageSendingOperations messagingTemplate;
	 
	 /**listens for connections to the chat
	 * @param event listens to when a connection is made
	 */
	@EventListener
	    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	        logger.info("Received a new web socket connection");
	 } 
	 
	 /**listens for when users disconnect
	 * @param event
	 */
	@EventListener
	    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
	        String username = (String) headerAccessor.getSessionAttributes().get("username");
	       
	        if(username != null) {
	            logger.info("User Disconnected : " + username);

	            Message chatMessage = new Message();
	            chatMessage.setType(Message.MessageType.LEAVE);
	            chatMessage.setSender(username);

	            messagingTemplate.convertAndSend("/topic/public", chatMessage);
	        }
	    }
	 
	 }
