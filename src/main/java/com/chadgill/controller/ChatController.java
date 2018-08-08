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
	
	@GetMapping("/chat")
	public String getPage() {
		return "chat";
	}

	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public Message getMessages(@Payload Message message) {
		System.out.println(message);
		return message;
	}
	
	 @MessageMapping("/chat.addUser")
	    @SendTo("/topic/public")
	    public Message addUser(@Payload Message message, 
	                               SimpMessageHeaderAccessor headerAccessor) {
	        // Add username in web socket session
	        headerAccessor.getSessionAttributes().put("username", message.getSender());
	        return message;
	    }
}
