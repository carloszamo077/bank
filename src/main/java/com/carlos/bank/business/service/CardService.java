package com.carlos.bank.business.service;

import com.carlos.bank.business.domain.BankCard;
import com.carlos.bank.common.aspect.Loggable;
import com.carlos.bank.data.entity.Card;
import com.carlos.bank.data.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {


    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Loggable
    public List<BankCard> getAll(){

        List<BankCard> bankCardList = new ArrayList<>();

        Iterable<Card> cards = this.cardRepository.findAll();

        cards.forEach(card -> {
            BankCard bankCard = new BankCard();
            bankCard.setCardDate(card.getCardDate());
            bankCard.setCardId(card.getCardId());
            bankCard.setCardName(card.getCardName());
            bankCard.setCardNumber(card.getCardNumber());
            //bankCard.setAccountId(card.getAccount().getAccountId());
            bankCardList.add(bankCard);
        });

        return bankCardList;
    }

    @Loggable
    public BankCard getByCardNumber(String cardNumber){

        Card card = this.cardRepository.findByCardNumber(cardNumber);
            BankCard bankCard = new BankCard();
            bankCard.setCardDate(card.getCardDate());
            bankCard.setCardId(card.getCardId());
            bankCard.setCardName(card.getCardName());
            bankCard.setCardNumber(card.getCardNumber());
            //bankCard.setAccountId(card.getAccount().getAccountId());

        return bankCard;
    }
}
