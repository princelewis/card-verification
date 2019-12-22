package com.lewis.cardverification.service;

public interface CardInfoService {

    InfoResponse getCardInfo(String cardNumber);
    StatResponse getStat(int start, int limit);
}
