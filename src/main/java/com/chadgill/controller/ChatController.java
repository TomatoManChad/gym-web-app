package com.chadgill.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chadgill.entity.Message;

@Controller
public class ChatController {
	
	/**retrieves chat jsp
	 * @return the chat jsp page
	 */
	@GetMapping("/chat")
	public String getPage() {
		return "chat";
	}

	
	
	/**retrieves messages
	 * @param message the message to be sent
	 * @return the message
	 */
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public Message getMessages(@Payload Message message) {
		System.out.println(message);
		return message;
	}
	
	 /**adds username to the message sent
	 * @param message the message being sent
	 * @param headerAccessor the username
	 * @return the message sent
	 */
	
	@MessageMapping("/chat.addUser")
	    @SendTo("/topic/public")
	    public Message addUser(@Payload Message message, 
	                               SimpMessageHeaderAccessor headerAccessor) {
	        // Add username in web socket session
	        headerAccessor.getSessionAttributes().put("username", message.getSender());
	        return message;
	    }
}
