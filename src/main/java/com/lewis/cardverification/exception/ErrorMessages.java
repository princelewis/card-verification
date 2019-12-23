package com.lewis.cardverification.exception;

import lombok.Data;


public enum ErrorMessages {
    EMPTY_LIST("input record was not found, list is empty"),
    NO_RECORD_FOUND("the input record was not found, card may not be registered "),
    OUT_OF_BOUNDS("the input range was not found. out of range"),
    INCOMPLETE_CARD_DIGIT("number of card digit was less than threshold ")
    ;

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
