package com.dbshacktron.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbshacktron.backend.models.Queue;

@RestController
public class SimpleController {

    @RequestMapping(value = "/")
    public String helloWorld() {
        return "Welcome to Hacktron";
    }
    
    @PostMapping("/createQueue")
    public ResponseEntity<String> createQueue(@RequestBody Queue queue ) {
    	
    	return null;
    }
    
    @DeleteMapping("/consumeQueue/{messageId}")
    public void removeFromQueue(String messageId) {
    	
    }
    
    @GetMapping("/getMessage")
    public String browseMessage() {
    	
    	return "";
    } 
   
    @DeleteMapping("/clearQueue")
    public ResponseEntity<String> clearQueue(){
    	
    	return null;
    }
    
}
