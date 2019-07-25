package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class AccountReadByStateService {

    private AccountState state;

    private List<Account> accounts;

    @Autowired
    private AccountRepository accountRepository;

    public void execute(){
     accounts = findAccountByState(state);
    }

    private List<Account> findAccountByState(AccountState state) {
        return accountRepository.findAllByStateOrderByEmailAsc(state);
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
