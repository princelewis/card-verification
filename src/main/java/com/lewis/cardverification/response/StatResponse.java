package com.lewis.cardverification.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class StatResponse implements Serializable {
    private boolean success;
    private int start;
    private int limit;
    private int size;
    private Map<String, Object> payload;

    public StatResponse(boolean success, int start, int limit, int size, Map<String, Object> payload) {
        this.success = success;
        this.start = start;
        this.limit = limit;
        this.size = size;
        this.payload = payload;
    }

}
