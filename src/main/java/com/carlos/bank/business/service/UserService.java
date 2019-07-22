package com.carlos.bank.business.service;

import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.domain.BankUser;
import com.carlos.bank.business.exceptions.UserNotFoundException;
import com.carlos.bank.common.aspect.Loggable;
import com.carlos.bank.data.entity.Account;
import com.carlos.bank.data.entity.User;
import com.carlos.bank.data.repository.AccountRepository;
import com.carlos.bank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Loggable
    public List<BankUser> getAll(){
        Iterable<User> users = this.userRepository.findAll();

        List<BankUser> bankUserList = new ArrayList<>();

        users.forEach(user ->{
            BankUser bankUser = new BankUser();
            bankUser.setUserId(user.getUserId());
            bankUser.setAddress(user.getAddress());
            bankUser.setCountry(user.getCountry());
            bankUser.setEmailAddress(user.getEmailAddress());
            bankUser.setFirstName(user.getFirstName());
            bankUser.setLastName(user.getLastName());
            bankUser.setPhoneNumber(user.getPhoneNumber());
            bankUser.setState(user.getState());
            bankUser.setDateTime(user.getDateTime());
            bankUserList.add(bankUser);
        });
        return bankUserList;
    }


    @Loggable
    public BankUser getByUserId(String userId){
        Optional<User> userOptional = this.userRepository.findByUserId(userId);

        if(!userOptional.isPresent()){
            return null;
        }

        User user = userOptional.get();
        BankUser bankUser = new BankUser();
            bankUser.setUserId(user.getUserId());
            bankUser.setAddress(user.getAddress());
            bankUser.setCountry(user.getCountry());
            bankUser.setEmailAddress(user.getEmailAddress());
            bankUser.setFirstName(user.getFirstName());
            bankUser.setLastName(user.getLastName());
            bankUser.setPhoneNumber(user.getPhoneNumber());
            bankUser.setState(user.getState());
            bankUser.setDateTime(user.getDateTime());

        return bankUser;
    }

    @Loggable
    public BankUser getByUserIdWithAccounts(String userId){
        Optional<User> userOptional = this.userRepository.findByUserId(userId);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-" + userId);
        }

        User user = userOptional.get();
        BankUser bankUser = new BankUser();
        bankUser.setUserId(user.getUserId());
        bankUser.setAddress(user.getAddress());
        bankUser.setCountry(user.getCountry());
        bankUser.setEmailAddress(user.getEmailAddress());
        bankUser.setFirstName(user.getFirstName());
        bankUser.setLastName(user.getLastName());
        bankUser.setPhoneNumber(user.getPhoneNumber());
        bankUser.setState(user.getState());
        bankUser.setDateTime(user.getDateTime());

        Iterable<Account> accountList = this.accountRepository.findByUserId(userId);

        List<BankAccount> bankAccountList = new ArrayList<>();
        accountList.forEach(account -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setDateTime(account.getDateTime());
            bankAccount.setAccountId(account.getAccountId());
            bankAccount.setBalance(account.getBalance());
            bankAccount.setName(account.getName());
            bankAccountList.add(bankAccount);
        });
        bankUser.setAccountList(bankAccountList);

        return bankUser;
    }

    @Loggable
    public BankUser save(BankUser bankUser){
        User user = new User();
        user.setUserId(user.getUserId());
        user.setAddress(user.getAddress());
        user.setCountry(user.getCountry());
        user.setEmailAddress(user.getEmailAddress());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setState(user.getState());
        user.setDateTime(user.getDateTime());

        this.userRepository.save(user);

        return bankUser;
    }

}
