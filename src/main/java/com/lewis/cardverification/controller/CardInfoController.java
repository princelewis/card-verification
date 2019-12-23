package com.lewis.cardverification.controller;

import com.lewis.cardverification.service.CardInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-scheme")
@CrossOrigin
public class CardInfoController {

    @Autowired
    private CardInfoServiceImpl cardInfoServiceImpl;

    @GetMapping("/verify/{cardNumber}")
    public ResponseEntity<?> cardInfoHandler (@PathVariable String cardNumber ){

        return new ResponseEntity<>(cardInfoServiceImpl.getCardInfo(cardNumber), HttpStatus.OK);
    }

    @GetMapping("/stats")
    public ResponseEntity<?> cardStatHandler (@RequestParam int start, int limit){
        return new ResponseEntity<>(cardInfoServiceImpl.getStat(start, limit), HttpStatus.OK);
    }
}
