package com.lewis.cardverification.service;

import com.lewis.cardverification.response.InfoResponse;
import com.lewis.cardverification.response.StatResponse;

public interface CardInfoService {

    InfoResponse getCardInfo(String cardNumber);
    StatResponse getStat(int start, int limit);
}
