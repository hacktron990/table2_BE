package com.dbshacktron.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dbshacktron.model.Message;
import com.dbshacktron.model.Queue;

public class MyService {
	private Map<String, Queue> map = new HashMap<>();

	public void storeMessages(String queueName,List<Message> messages) {
		if (map.containsKey(queueName)) {
			Queue queue = map.get(queueName);
			queue.setMessages(messages);
		} else {
			Queue queue =new Queue();
			queue.setMessages(messages);
			map.put(queueName, queue);
		}
	}
	public List<Message> getMessages(String queue){
		return map.get(queue).getMessages();
	}
}
