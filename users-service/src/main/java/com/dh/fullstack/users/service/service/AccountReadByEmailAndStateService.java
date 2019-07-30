package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.framework.context.ServiceTransactional;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Santiago Mamani
 */
@ServiceTransactional
public class AccountReadByEmailAndStateService {

    private String email;

    private AccountState state;

    private Account account;

    @Autowired
    private AccountRepository accountRepository;

    public void execute(){
     account = findAccountByEmailAndState(email,state);
    }

    private Account findAccountByEmailAndState(String email, AccountState state) {
        return accountRepository.findAccount(email,state)
                .orElse(null);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }
}
