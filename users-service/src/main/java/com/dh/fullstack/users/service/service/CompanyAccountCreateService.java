package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.config.UsersMyProperties;
import com.dh.fullstack.users.service.config.UsersProperties;
import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.input.CompanyCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class CompanyAccountCreateService {

    private CompanyCreateInput input;

    private Account account;

    @Autowired
    private AccountRepository accountRepository;

    public void execute() {
        account = accountRepository.save(composeAccountInstance());
    }

    private Account composeAccountInstance() {
        Account instance = new Account();
        instance.setEmail(input.getEmail());
        instance.setState(AccountState.ACTIVATED);
        return instance;
    }

    public Account getAccount() {
        return account;
    }

    public void setInput(CompanyCreateInput input) {
        this.input = input;
    }
}
