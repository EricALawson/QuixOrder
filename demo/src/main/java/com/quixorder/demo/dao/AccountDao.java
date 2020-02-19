package com.quixorder.demo.dao;

import com.quixorder.demo.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The AccountDao interface is an abstraction of all request methods to be used by any database
 */
public interface AccountDao {
    int insertAccount (UUID id, Account account);

    default int insertAccount(Account account) {
        UUID id = UUID.randomUUID();
        return insertAccount(id, account);
    }

    List<Account> selectAllAccount();

    Optional<Account> selectAccountById(UUID id);
    Optional<Account> selectAccountByUsername(String username);
    int deleteAccountById(UUID id);
    int updateAccountById(UUID id, Account account);
}
