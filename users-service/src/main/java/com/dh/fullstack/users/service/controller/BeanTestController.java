package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.Asus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@RestController
@RequestMapping("/beans")
@RequestScope
public class BeanTestController {

    private Integer value = 1;

    @Autowired
    private Asus asus;
// DI por setter
//    @Autowired
//    public void setAsus(Asus asus) {
//        this.asus = asus;
//    }
// DI Por constructor
//    public BeanTestController(Asus asus) {
//        this.asus = asus;
//    }
//    public AccountController() {
//        this.asus = new Asus(); NO usar jamas
//    }
    @RequestMapping(value = "/asus", method = RequestMethod.GET)
    public Asus readAsus() {
        value = value + 1;
        asus.setName(asus.getName() + ": GET"+ ", Value: " +value);
        return asus;
    }
}
