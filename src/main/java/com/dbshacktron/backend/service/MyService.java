package com.dbshacktron.backend.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dbshacktron.backend.models.DataSet;
import com.dbshacktron.backend.models.Message;
import com.dbshacktron.backend.models.Queue;

@Service
public class MyService {

    public Long storeMessages(long queue, Message message) {
        long messageId = -1;
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        if (map.containsKey(queue)) {
            Date date = new Date();
            messageId = date.getTime();
            message.setId(messageId);
            map.get(queue).getMessages().add(message);
        }
        return messageId;
    }

    public List<Message> getMessages(long id){
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        return map.get(id).getMessages();
    }
    
    public void clearQueue(long queueId) {
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        map.remove(queueId);        
    }
    
    public void deleteMessage(long queueId, String messageId) {
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        if (map.containsKey(queueId)) {
            Queue q = map.get(queueId);
            List<Message> msgList = q.getMessages();
            for (Message m : msgList) {
                if (m.getId() == Long.parseLong(messageId)) {
                    msgList.remove(m);
                }
            }
        }
    }
    
    public Long createQueue(Queue queue) {
        long queueId = -1;
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        Date date = new Date();
        queueId = date.getTime();
        map.put(queueId, queue);
        return queueId;
    }
}
