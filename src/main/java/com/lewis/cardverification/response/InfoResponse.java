package com.lewis.cardverification.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class InfoResponse implements Serializable {
    private boolean success;
    private Object payload;
//    HashMap<String, Object>

    public InfoResponse(boolean success, Object payload) {
        this.success = success;
        this.payload = payload;
    }

}
