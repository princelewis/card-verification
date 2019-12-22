package com.lewis.cardverification.repository;

import com.lewis.cardverification.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
    CardInfo findByCardNumber(String cardNumber);
}
