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
    public ResponseEntity<Long> createQueue(@RequestBody Queue queue) {
        long id = myService.createQueue(queue);
        if( id != -1) {
            return new ResponseEntity(id,HttpStatus.CREATED);
        }
        return new ResponseEntity(id,HttpStatus.BAD_REQUEST);
    }
    
    @SuppressWarnings("rawtypes")
    @PostMapping("/queue/{queueId}/message")
    public ResponseEntity<Long> createMeassge(@PathVariable long queueId,@RequestBody Message message ) {
        long messageId = myService.storeMessages(queueId, message);
        if(messageId != -1) {
            return new ResponseEntity(messageId,HttpStatus.CREATED);
        }
        return new ResponseEntity(messageId,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/queue/{queueId}/message/{messageId}")
    public void removeFromQueue(@PathVariable Long queueId,@PathVariable String messageId) {
        myService.deleteMessage(queueId, messageId);
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
