package com.carlos.bank.business.service;

import com.carlos.bank.business.domain.BankCard;
import com.carlos.bank.common.aspect.Loggable;
import com.carlos.bank.data.entity.Account;
import com.carlos.bank.data.entity.Card;
import com.carlos.bank.data.repository.AccountRepository;
import com.carlos.bank.data.repository.CardRepository;
import com.carlos.bank.business.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private CardRepository cardRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    @Loggable
    public List<BankAccount> getAll(){
        Iterable<Account> accounts = this.accountRepository.findAll();

        List<BankAccount> bankAccountList = new ArrayList<>();

        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setBalance(account.getBalance());
            bankAccount.setName(account.getName());
            bankAccount.setDateTime(account.getDateTime());
            bankAccountList.add(bankAccount);
        });
        return bankAccountList;
    }

    @Loggable
    public List<BankAccount> getAccountByUser(String userId){
        Iterable<Account> accounts = this.accountRepository.findByUserId(userId);

        List<BankAccount> bankAccountList = new ArrayList<>();

        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setBalance(account.getBalance());
            bankAccount.setName(account.getName());
            bankAccount.setDateTime(account.getDateTime());

            bankAccountList.add(bankAccount);
        });
        return bankAccountList;
    }

    @Loggable
    public List<BankAccount> getAccountByUserWithCards(String userId){
        Iterable<Account> accounts = this.accountRepository.findByUserId(userId);

        List<BankAccount> bankAccountList = new ArrayList<>();

        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setBalance(account.getBalance());
            bankAccount.setName(account.getName());
            bankAccount.setDateTime(account.getDateTime());

            Iterable<Card> cards = this.cardRepository.findByAccountId(account.getAccountId());
            List<BankCard> bankCardList = new ArrayList<>();
            cards.forEach(card -> {
                BankCard bankCard = new BankCard();
                bankCard.setName(card.getName());
                bankCard.setDateTime(card.getDateTime());
                bankCard.setAccountId(card.getAccountId());
                bankCard.setCardId(card.getCardId());
                bankCardList.add(bankCard);
            });
            bankAccount.setCardList(bankCardList);

            bankAccountList.add(bankAccount);
        });
        return bankAccountList;
    }


   /*public List<BankAccount> getUserAccounts(String userId){
        Iterable<Account> accounts = this.accountRepository.findByUserId(userId);

        List<BankAccount> bankAccounts = new ArrayList<>();
        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setUserId(account.getUserId());
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setAccountBalance(account.getAccountBalance());
            bankAccount.setAccountName(account.getAccountName());
            bankAccount.setUserFirstName("");
            bankAccount.setUserLastName("");
            bankAccount.setUserDate(account.getAccountDate());

            Iterable<Card> cards = this.cardRepository.findByAccountId(account.getAccountId());
            List<BankCard> listCards = new ArrayList<>();

            cards.forEach(card -> {
                BankCard accountCard = new BankCard();
                accountCard.setCardId(card.getCardId());
                accountCard.setCardName(card.getCardName());
                accountCard.setCardNumber(card.getCardNumber());
                accountCard.setCardDate(card.getCardDate());
                listCards.add(accountCard);
            });
            bankAccount.setListCard(listCards);

            bankAccounts.add(bankAccount);
        });

        return bankAccounts;
    }*/

}
