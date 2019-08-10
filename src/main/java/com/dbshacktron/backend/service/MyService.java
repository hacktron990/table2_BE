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

    public boolean storeMessages(long queue, Message message) {
        boolean status = false;
        Map<Long, Queue> map= DataSet.getInstance().getDataSet();
        if (map.containsKey(queue)) {
            Date date = new Date();
            long time = date.getTime();
            message.setId(time);
            map.get(queue).getMessages().add(message);
            status = true;
        }
        return status;
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
                if (m.getId() == Integer.parseInt(messageId)) {
                    msgList.remove(m);
                }
            }
        }
    }
}
