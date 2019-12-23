package com.lewis.cardverification.service;

import com.lewis.cardverification.exception.CardInfoServiceException;
import com.lewis.cardverification.exception.ErrorMessages;
import com.lewis.cardverification.model.CardInfo;
import com.lewis.cardverification.pojo.ResponsePojo;
import com.lewis.cardverification.repository.CardInfoRepository;
import com.lewis.cardverification.response.InfoResponse;
import com.lewis.cardverification.response.StatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    private InfoResponse cardInfo(String cardNumber) throws RestClientException {

        if (cardNumber.length() < 6) {
            throw new CardInfoServiceException(ErrorMessages.INCOMPLETE_CARD_DIGIT.getErrorMessage());
        }

        String newCardNumber = cutOutFirstSixChar(cardNumber);

        Map<String, Object> payload = new HashMap<>();


        ResponsePojo thirdPartyApiResponse = restTemplate.getForObject("https://lookup.binlist.net/" + newCardNumber, ResponsePojo.class);

        if(thirdPartyApiResponse == null){
            throw new CardInfoServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }

        CardInfo cardInfoEntity = new CardInfo(thirdPartyApiResponse.getType(), thirdPartyApiResponse.getScheme(), thirdPartyApiResponse.getBank().getName(), newCardNumber, true);

        CardInfo savedDetails = cardInfoRepository.save(cardInfoEntity);

        payload.put("scheme", savedDetails.getScheme());
        payload.put("type", savedDetails.getCardType());
        payload.put("bank", savedDetails.getBank());

        return new InfoResponse(true, payload);
    }

    private String cutOutFirstSixChar(String cardNumber){
        return cardNumber.substring(0,6);
    }
}
