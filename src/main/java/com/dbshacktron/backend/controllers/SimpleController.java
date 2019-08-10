package com.dbshacktron.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbshacktron.backend.models.Message;
import com.dbshacktron.backend.models.Queue;
import com.dbshacktron.backend.service.MyService;

@RestController
public class SimpleController {
	@Autowired
	private MyService myService;

	@RequestMapping(value = "/")
	public String helloWorld() {
		return "Welcome to Hacktron";
	}
	@PostMapping("/queue")
	public ResponseEntity<String> createQueue(@RequestBody Queue queue) {
    	return null;
    }
    
    @PostMapping("/queue/{queueId}/message")
    public ResponseEntity<String> createMeassge(@PathVariable String queueId,@RequestBody Message message ) {

		return null;
	}
	@PostMapping("/message/{queueId}")
	public void createMeassge(@RequestBody List<Message> message, @PathVariable("queueId") String queueId) {
		myService.storeMessages(queueId, message);
	}

	@DeleteMapping("/queue/{queueId}/message/{messageId}")
	public void removeFromQueue(String queueId, String messageId) {
	}
	@GetMapping("/queue/{queueId}/message/{messageId}")
	public Message browseMessage() {

		return new Message();
	}

	@DeleteMapping("/queue/{queueId}")
	public void clearQueue(@PathVariable("queueId")String queueId) {
		myService.clearQueue(queueId);
	}

	@GetMapping("/queue/{queueId}/message")
	public List<Message> ListOfMessage(@PathVariable("queueId") String queueId) {

		return myService.getMessages(queueId);
	}

}
