package com.quixorder.demo.api;

import com.quixorder.demo.model.Account;
import com.quixorder.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The AccountController class is an @RestController that receives requests from an API, and injects AccountService
 * methods to complete them.
 */
@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    /**
     * AccountController is a constructor that injects AccountService methods
     * @param accountService
     */
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void addAccount(@Valid @NonNull @RequestBody Account account) {
        accountService.addAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @GetMapping(path = "/id/{id}")
    public Account getAccountById(@PathVariable("id") UUID id) {
        return accountService.getAccountById(id)
                .orElse(null);
    }

    @GetMapping(path="/username/{username}")
    public Account getAccountByUsername(@PathVariable("username") String username) {
        return accountService.getAccountByUsername(username)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAccountById(@PathVariable("id") UUID id) {
        accountService.deleteAccount(id);
    }

    @PutMapping(path = "{id}")
    public void updateAccountById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Account accountToUpdate) {
        accountService.updateAccount(id, accountToUpdate);
    }
}