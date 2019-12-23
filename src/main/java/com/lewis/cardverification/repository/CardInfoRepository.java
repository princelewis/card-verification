package com.lewis.cardverification.repository;

import com.lewis.cardverification.model.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
    CardInfo findByCardNumber(String cardNumber);

    @Query("SELECT COUNT (cardInfo.success), cardInfo.cardNumber FROM CardInfo  cardInfo GROUP BY cardInfo.cardNumber ORDER BY COUNT (cardInfo.success) DESC ")
    List<List> sortByCardNumber();
}
