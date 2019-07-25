package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.input.EmployeeCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.Employee;
import com.dh.fullstack.users.service.service.AccountCreateService;
import com.dh.fullstack.users.service.service.EmployeeCreateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@Api(
        tags = "employee",
        description = "Operations over employees"
)
@RestController
@RequestMapping("/public/employees")
@RequestScope
public class EmployeeController {

    @Autowired
    private EmployeeCreateService employeeCreateService;

    @ApiOperation(
            value = "Create an employee"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create account"
            )
    })
    @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody EmployeeCreateInput input) {
        employeeCreateService.setInput(input);
        employeeCreateService.execute();

        return employeeCreateService.getEmployee();
    }
}
