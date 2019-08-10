package com.dbshacktron.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbshacktron.backend.models.Message;
import com.dbshacktron.backend.models.Queue;

@RestController
public class SimpleController {

    @RequestMapping(value = "/")
    public String helloWorld() {
        return "Welcome to Hacktron";
    }
    
    @PostMapping("/queue")
    public ResponseEntity<String> createQueue(@RequestBody Queue queue ) {

    	return null;
    }
    
    @PostMapping("/message")
    public ResponseEntity<String> createMeassge(@RequestBody Message message ) {

    	return null;
    }
    
    @DeleteMapping("/queue/{queueId}/message/{messageId}")
    public void removeFromQueue(String queueId, String messageId) {
    	
    }
    
    @GetMapping("/queue/{queueId}/message/{messageId}")
    public Message browseMessage() {
    	
    	return new Message();
    } 
   
    @DeleteMapping("/queue/{queueId}")
    public ResponseEntity<String> clearQueue(){
    	
    	return null;
    }
    
    @GetMapping("/queue/{queueId}/message")
    public List<Message> ListOfMessage() {
    	
    	return null;
    } 
    
}
