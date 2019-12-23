package com.lewis.cardverification.exception;

import lombok.Data;

@Data
public class CardInfoServiceException extends RuntimeException{

    private String message;

    public CardInfoServiceException(String message) {
        super();
        this.message = message;
    }

}
