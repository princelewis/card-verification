package com.lewis.cardverification.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "card_info")
public class CardInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "card_type")
    private String cardType;
    private String scheme;
    private String bank;

    @Column(name="card_number")
    private String cardNumber;
    private boolean success;

    public CardInfo() {
    }

    public CardInfo(String cardType, String scheme, String bank, String cardNumber, boolean success) {
        this.cardType = cardType;
        this.scheme = scheme;
        this.bank = bank;
        this.cardNumber = cardNumber;
        this.success = success;
    }

}
