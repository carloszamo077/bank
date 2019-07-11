package com.carlos.bank.web.service;

import com.carlos.bank.business.domain.BankCard;
import com.carlos.bank.business.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cards")
public class CardServiceController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<BankCard> getCard(@RequestParam(required=false) String cardNumber){
        List<BankCard> bankCardList =  new ArrayList<>();
        if(null==cardNumber){
            return this.cardService.getAll();
        }else {
            BankCard bankCard = this.cardService.getByCardNumber(cardNumber);
            bankCardList.add(bankCard);
            return bankCardList;
        }
    }
}
