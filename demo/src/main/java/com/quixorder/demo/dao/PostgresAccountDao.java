package com.quixorder.demo.dao;

import com.quixorder.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The PostgresAccountDao is an AccountDao subclass that uses sql commands to fulfill PostgreSQL database requests
 */
@Repository("postgres")
public class PostgresAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * The function insertAccount(id, account) adds a new entry into the account table
     * @param id This is the primary key for account that is being added
     * @param account This holds all other values for account
     * @return
     */
    @Override
    public int insertAccount(UUID id, Account account) {
        final String sql = "INSERT INTO account (id, type, username, password) VALUES(?, ?, ?, ?)";
        String type = account.getType();
        String username = account.getUsername();
        String password = account.getPassword();
        return jdbcTemplate.update(sql, id, type, username, password);
    }

    /**
     * The function selectAllAccount() selects all accounts and returns it
     * @return a list of all account objects
     */
    @Override
    public List<Account> selectAllAccount() {
        final String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
           UUID id = UUID.fromString(resultSet.getString("id"));
           String type = resultSet.getString("type");
           String username = resultSet.getString("username");
           String password = resultSet.getString("password");
           return new Account(id, type, username, password);
        });
    }

    /**
     * The function selectAccountById() searches for an account ID and returns it
     * @param accountId This is the primary key for account that is being searched for
     * @return the entry whose ID matches
     */
    @Override
    public Optional<Account> selectAccountById(UUID accountId) {
        final String sql = "SELECT * FROM account WHERE id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{accountId}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String type = resultSet.getString("type");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Account(id, type, username, password);
        });
        return Optional.ofNullable(account);
    }

    /**
     * The function selectAccountByUsername() searches for an account by Username and returns it
     * @param accountUsername This is the username for account that is being searched for
     * @return the entry whose Username matches
     */
    @Override
    public Optional<Account> selectAccountByUsername(String accountUsername) {
        final String sql = "SELECT * FROM account WHERE username = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{accountUsername}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String type = resultSet.getString("type");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new Account(id, type, username, password);
        });
        return Optional.ofNullable(account);
    }

    /**
     * The function deleteAccountById() searches and deletes an account
     * @param id This is the primary key for account that is being deleted
     * @return the number of entries deleted
     */
    @Override
    public int deleteAccountById(UUID id) {
        final String sql = "DELETE FROM account WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * The function updateAccountById() searches and updates an account with new information
     * @param id This is the primary key for account that is being updated
     * @param account This holds the information to update with
     * @return the number of entries updated
     */
    @Override
    public int updateAccountById(UUID id, Account account) {
        final String sql = "UPDATE account SET type = ?, username = ?, password = ? WHERE id = ?";
        String type = account.getType();
        String username = account.getUsername();
        String password = account.getPassword();
        return jdbcTemplate.update(sql, type, username, password, id);
    }
}