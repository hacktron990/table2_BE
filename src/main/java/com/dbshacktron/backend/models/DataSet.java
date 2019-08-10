package com.dbshacktron.backend.models;

import java.util.HashMap;
import java.util.Map;

public class DataSet {
    
    private static DataSet INSTANCE = new DataSet();
    private Map<Long, Queue> dataset = new HashMap<Long, Queue>();
    private DataSet() {
    }

    public static DataSet getInstance() {
        return INSTANCE;
    }
    
    public Map<Long, Queue> getDataSet() {
        return dataset;
    }
    
    public Queue getQueue(Long id) {
        return dataset.get(id);
    }
}
