package com.lewis.cardverification.service;

import com.lewis.cardverification.repository.CardInfoRepository;
import com.lewis.cardverification.response.InfoResponse;
import com.lewis.cardverification.response.StatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardInfoServiceImpl implements CardInfoService {

    private CardInfoRepository cardInfoRepository;

    private RestTemplate restTemplate;

    @Autowired
    public CardInfoServiceImpl(CardInfoRepository cardInfoRepository, RestTemplate restTemplate){
        this.cardInfoRepository = cardInfoRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public InfoResponse getCardInfo(String cardNumber) {

        return cardInfo(cardNumber);
    }

    @Override
    public StatResponse getStat(int start, int limit) {
        return cardStat(start, limit);
    }

}
