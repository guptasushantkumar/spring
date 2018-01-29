package com.tima;

import java.util.Map;

public class MessageReceiver {

	public void receiveMessage(Map<String, String> message) {
		String value = message.get("msg");
		System.out.println("Message received from activemq: " + value);
	}
}
