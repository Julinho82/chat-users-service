package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.input.EmployeeCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.domain.Employee;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import com.dh.fullstack.users.service.model.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class EmployeeCreateService {

    private EmployeeCreateInput input;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Employee employee;

    public void execute(){
        Account account = composeAccountInstance();
        account = accountRepository.save(account);

        Employee employeeInstance = composeEmployeeInstance(account);
        employee = employeeRepository.save(employeeInstance);
    }

    private Account composeAccountInstance() {
        Account instance = new Account();
        instance.setState(AccountState.DEACTIVATED);
        instance.setEmail(input.getEmail());

        return instance;
    }

    private Employee composeEmployeeInstance(Account account) {
        Employee instance = new Employee();
        instance.setFirstName(input.getFirstName());
        instance.setLastName(input.getLastName());
        instance.setEmail(input.getEmail());
        instance.setPassword(input.getPassword());
        instance.setActive(Boolean.TRUE);
        instance.setCreatedDate(new Date());
        instance.setAccount(account);

        return instance;
    }

    public void setInput(EmployeeCreateInput input) {
        this.input = input;
    }

    public Employee getEmployee() {
        return employee;
    }
}
