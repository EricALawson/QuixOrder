package com.quixorder.demo.service;

import com.quixorder.demo.dao.AccountDao;
import com.quixorder.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The AccountService class is an @Service class to inject methods from a class that has database interactions.
 * @Qualifier is used to easily switch between any database.
 */
@Service
public class AccountService {

    private final AccountDao accountDao;

    /**
     * AccountService is a constructor that injects AccountDao methods
     * @param accountDao
     */
    @Autowired
    public AccountService(@Qualifier("postgres") AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public int addAccount(Account account) {
        return accountDao.insertAccount(account);
    }

    public List<Account> getAllAccount() {
        return accountDao.selectAllAccount();
    }

    public Optional<Account> getAccountById(UUID id) {
        return accountDao.selectAccountById(id);
    }

    public Optional<Account> getAccountByUsername(String username) {
        return accountDao.selectAccountByUsername(username);
    }

    public int deleteAccount(UUID id) {
        return accountDao.deleteAccountById(id);
    }

    public int updateAccount(UUID id, Account newAccount) {
        return accountDao.updateAccountById(id, newAccount);
    }
}
