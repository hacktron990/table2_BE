package com.dbshacktron.backend.models;

import java.util.HashMap;
import java.util.Map;

public class DataSet {
    
    private static DataSet INSTANCE = new DataSet();
    private Map<String, Queue> dataset = new HashMap<String, Queue>();
    private DataSet() {
    }

    public static DataSet getInstance() {
        return INSTANCE;
    }
    
    public Map<String, Queue> getDataSet() {
        return dataset;
    }
    
    public Queue getQueue(String queuename) {
        return dataset.get(queuename);
    }
}
