package com.dbshacktron.backend.service;

import java.util.HashMap;
import java.util.Map;

import com.dbshacktron.backend.models.Queue;

public class MyService {
	private Map<String, Queue> map = new HashMap<>();

	public void storeMessages(Queue queue) {
		if(map.containsKey(queue.getQueueName())){
			
		}
		map.put(queue.getQueueName(), queue);
	}
}
