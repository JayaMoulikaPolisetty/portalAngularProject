package com.niit.portalmiddleware.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.niit.portalbackend.Message;
import com.niit.portalbackend.OutputMessage;

@Controller
@CrossOrigin("http://127.0.0.1:3000")
public class ChatController {
	
	@MessageMapping("/chat/")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message) {
		System.out.println("hello");
		return new OutputMessage(message, new Date());
	}

}
