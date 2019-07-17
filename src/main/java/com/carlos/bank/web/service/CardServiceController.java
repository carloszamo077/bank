package com.carlos.bank.web.service;

import com.carlos.bank.business.domain.BankCard;
import com.carlos.bank.business.exceptions.CardNotFoundException;
import com.carlos.bank.business.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
public class CardServiceController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<BankCard> getAllCards(){
            return this.cardService.getAll();
    }

    /*@RequestMapping(value = "/cards/all", method = RequestMethod.GET)
    public List<BankCard> getCards(@RequestParam(required=false) String cardNumber){
        List<BankCard> bankCardList =  new ArrayList<>();
        if(null==cardNumber){
            return this.cardService.getAll();
        } else {
            BankCard bankCard = this.cardService.getByCardNumber(cardNumber);
            bankCardList.add(bankCard);
            return bankCardList;
        }
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/cards/{cardNumber}")
    public Resource<BankCard> getCard(@PathVariable String cardNumber){
        BankCard bankCard = this.cardService.getByCardNumber(cardNumber);

        if(bankCard == null){
            throw new CardNotFoundException("cardNumber-" + cardNumber);
        }
            Resource<BankCard> resource = new Resource<>(bankCard);
            ControllerLinkBuilder linkTo =
                    linkTo(methodOn(CardServiceController.class).getAllCards());
            resource.add(linkTo.withRel("all-cards"));
        return resource;
    }
}
