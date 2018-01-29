package com.tima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msgservice")
public class MessageService {

	@Autowired
	private MessageSender sender;

	public void sendMessage() {
		String msg = "Why is this first message?";
		sender.sendMessage(msg);
	}
}
