package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.service.AccountCreateService;
import com.dh.fullstack.users.service.service.AccountReadByEmailAndStateService;
import com.dh.fullstack.users.service.service.AccountReadByStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Santiago Mamani
 */
@Api(
        tags = "account rest",
        description = "Operations over accounts"
)
@RestController
@RequestMapping("/accounts")
@RequestScope
public class AccountController {

    @Autowired
    private AccountCreateService accountCreateService;

    @Autowired
    private AccountReadByEmailAndStateService accountReadByEmailAndStateService;

    @Autowired
    private AccountReadByStateService accountReadByStateService;

    @ApiOperation(
            value = "Endpoint to create account"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create account"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Not fount test"
            )
    })
    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountInput input) {
        accountCreateService.setInput(input);
        return accountCreateService.save();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Account readAccountByEmailAndState(@RequestParam("email") String email,
                                              @RequestParam("state") AccountState state) {
        accountReadByEmailAndStateService.setEmail(email);
        accountReadByEmailAndStateService.setState(state);
        accountReadByEmailAndStateService.execute();

        return accountReadByEmailAndStateService.getAccount();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> listAccountByState(@RequestParam("state") AccountState state) {
        accountReadByStateService.setState(state);
        accountReadByStateService.execute();

        return accountReadByStateService.getAccounts();
    }
}
