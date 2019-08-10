package com.dbshacktron.service;

import java.util.HashMap;
import java.util.Map;

import com.dbshacktron.model.Queue;

public class MyService {
	private Map<String, Queue> map = new HashMap<>();

	public void storeMessages(Queue queue) {
		if(map.containsKey(queue.getQueueName())){
			
		}
		map.put(queue.getQueueName(), queue);
	}
}
