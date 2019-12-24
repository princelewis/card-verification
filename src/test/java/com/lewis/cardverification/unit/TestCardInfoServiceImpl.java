package com.lewis.cardverification.unit;

import com.lewis.cardverification.model.CardInfo;
import com.lewis.cardverification.pojo.Bank;
import com.lewis.cardverification.pojo.ResponsePojo;
import com.lewis.cardverification.repository.CardInfoRepository;
import com.lewis.cardverification.response.InfoResponse;
import com.lewis.cardverification.service.CardInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestCardInfoServiceImpl {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CardInfoRepository cardInfoRepository;

    @InjectMocks
    private CardInfoServiceImpl cardInfoServiceImpl;


    @Test
    public void testCardInfo(){
        Map<String, Object> payload = new HashMap<String, Object>(){{
                put("bank", "HSBC BANK USA");
                put("scheme", "mastercard");
                put("type", null);
        }};
        InfoResponse infoResponse = new InfoResponse(true, payload);


        Bank bank = new Bank();
        bank.setName("HSBC BANK USA");
        bank.setUrl("www.us.hsbc.com");
        bank.setPhone("800.975.4722");

        ResponsePojo thirdPartyApiResponse = new ResponsePojo();
        thirdPartyApiResponse.setBank(bank);
        thirdPartyApiResponse.setScheme("mastercard");

        String cardNumber = "543234";

        when(restTemplate.getForObject("https://lookup.binlist.net/" + cardNumber, ResponsePojo.class)).thenReturn(thirdPartyApiResponse);

        when(cardInfoRepository.save(any())).thenReturn(new CardInfo());

        InfoResponse result = cardInfoServiceImpl.getCardInfo("543234");

        assertEquals(result, infoResponse);
    }


}
