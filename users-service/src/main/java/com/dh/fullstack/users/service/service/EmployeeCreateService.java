package com.dh.fullstack.users.service.service;

import com.dh.chat.contact.service.input.ContactCreateInput;
import com.dh.fullstack.users.service.client.contact.service.SystemContactService;
import com.dh.fullstack.users.service.framework.context.ServiceTransactional;
import com.dh.fullstack.users.service.input.EmployeeCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.domain.Employee;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import com.dh.fullstack.users.service.model.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Santiago Mamani
 */
@ServiceTransactional
public class EmployeeCreateService {

    private EmployeeCreateInput input;

    @Autowired
    private SystemContactService systemContactService;

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

        createContact(account, employee);
    }

    private void createContact(Account account, Employee employee) {
        ContactCreateInput input = new ContactCreateInput();
        input.setAccountId(account.getId());
        input.setUserId(employee.getId());
        input.setName(employee.getLastName() + " " + employee.getFirstName());
        input.setEmail(employee.getEmail());

        systemContactService.createContact(input);
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
