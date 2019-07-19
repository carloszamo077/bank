package com.carlos.bank.business.service;

import com.carlos.bank.common.aspect.Loggable;
import com.carlos.bank.data.entity.Account;
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
    public List<BankAccount> getAccountByUser(String userId){
        Iterable<Account> accounts = this.accountRepository.findByUserId(userId);

        List<BankAccount> bankAccountList = new ArrayList<>();

        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setUserId(account.getUser().getId());
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setAccountBalance(account.getAccountBalance());
            bankAccount.setAccountName(account.getAccountName());
            bankAccount.setAccountDate(account.getAccountDate());

            bankAccountList.add(bankAccount);
        });
        return bankAccountList;
    }

    @Loggable
    public List<BankAccount> getAll(){
        Iterable<Account> accounts = this.accountRepository.findAll();

        List<BankAccount> bankAccountList = new ArrayList<>();

        accounts.forEach(account ->{
            BankAccount bankAccount = new BankAccount();
            bankAccount.setUserId(account.getUser().getId());
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setAccountBalance(account.getAccountBalance());
            bankAccount.setAccountName(account.getAccountName());
            bankAccount.setAccountDate(account.getAccountDate());

            bankAccountList.add(bankAccount);
        });
        return bankAccountList;
    }

   /* public List<BankAccount> getUserAccounts(String userId){
        Iterable<Account> accounts = this.accountRepository.findByUserId(userId);

        Map<Long, BankAccount> userAccountMap = new HashMap<>();

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

            userAccountMap.put(account.getAccountId(), bankAccount);
        });

        List<BankAccount> bankAccounts = new ArrayList<>();
        for(Long accountId : userAccountMap.keySet()){
            bankAccounts.add(userAccountMap.get(accountId));
        }
        return bankAccounts;
    }*/

}
