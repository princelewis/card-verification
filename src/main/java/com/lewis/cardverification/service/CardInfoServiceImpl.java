package com.lewis.cardverification.service;

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
}
