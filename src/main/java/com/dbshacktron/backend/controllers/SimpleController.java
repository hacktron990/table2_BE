package com.dbshacktron.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/queue/{queueId}/message")
    public ResponseEntity createMeassge(@PathVariable long queueId,@RequestBody Message message ) {
    	if(myService.storeMessages(queueId, message)) {
    		return new ResponseEntity(HttpStatus.CREATED);
    	}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/queue/{queueId}/message/{messageId}")
	public void removeFromQueue(String queueId, String messageId) {
	}
	@GetMapping("/queue/{queueId}/message/{messageId}")
	public Message browseMessage() {

		return new Message();
	}

	@DeleteMapping("/queue/{queueId}")
	public void clearQueue(@PathVariable("queueId")long queueId) {
		myService.clearQueue(queueId);
	}

	@GetMapping("/queue/{queueId}/message")
	public List<Message> ListOfMessage(@PathVariable("queueId") long queueId) {

		return myService.getMessages(queueId);
	}

}
