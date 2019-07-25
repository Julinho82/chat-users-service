package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.config.UsersMyProperties;
import com.dh.fullstack.users.service.config.UsersProperties;
import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class AccountCreateService {

    private AccountInput input;

    @Autowired
    private UsersProperties usersProperties;

    @Autowired
    private UsersMyProperties usersMyProperties;

    @Autowired
    private AccountRepository accountRepository;

    public Account save() {
        System.out.println("countUser: " + usersProperties.getCountUser());
        System.out.println("nameAsus: " + usersProperties.getNameAsus());
        System.out.println("nameAsus: " + usersMyProperties.getApiVersion());

        return accountRepository.save(composeAccountInstance());
    }

    private Account composeAccountInstance() {
        AccountState state=AccountState.DEACTIVATED;
        Boolean isPermit =  isPermit();
        if (isPermit){
            state = AccountState.ACTIVATED;
        }

        Account instance = new Account();
        instance.setState(state);
        instance.setEmail(input.getEmail());

        return instance;
    }

    private Boolean isPermit(){
       return input.getAge()>=usersProperties.getPermitAge();
    }

    public void setInput(AccountInput input) {
        this.input = input;
    }
}
