package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.framework.context.ServiceTransactional;
import com.dh.fullstack.users.service.input.CompanyCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.Company;
import com.dh.fullstack.users.service.model.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Santiago Mamani
 */
@ServiceTransactional
public class CompanyCreateService {

    private CompanyCreateInput input;

    @Autowired
    private CompanyAccountCreateService companyAccountCreateService;

    @Autowired
    private CompanyRepository companyRepository;

    private Company company;

    public void execute(){
        Account account= createAccount();
         generateError();
        company = companyRepository.save(composeCompanyInstance(account));
    }

    private void generateError() {
        throw  new RuntimeException("Error in account table.");
    }

    private Company composeCompanyInstance(Account account) {
        Company instance = new Company();
        instance.setName(input.getName());
        instance.setEmail(input.getEmail());
        instance.setActive(Boolean.TRUE);
        instance.setPassword(input.getPassword());
        instance.setAccount(account);

        return instance;
    }

    private Account createAccount() {
        companyAccountCreateService.setInput(input);
        companyAccountCreateService.execute();

        return companyAccountCreateService.getAccount();
    }

    public void setInput(CompanyCreateInput input) {
        this.input = input;
    }

    public Company getCompany() {
        return company;
    }
}
