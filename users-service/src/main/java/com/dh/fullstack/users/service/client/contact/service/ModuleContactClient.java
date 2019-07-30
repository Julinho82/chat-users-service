package com.dh.fullstack.users.service.client.contact.service;

import com.dh.chat.contact.service.input.ContactCreateInput;
import com.dh.fullstack.users.service.client.contact.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Santiago Mamani
 */
@FeignClient("${contact.service.name}")
interface ModuleContactClient {

    @RequestMapping(
            value = "/system/contacts",
            method = RequestMethod.POST
    )
    Contact createContact(@RequestBody ContactCreateInput input);
}
