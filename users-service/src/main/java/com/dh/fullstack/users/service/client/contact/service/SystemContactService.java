package com.dh.fullstack.users.service.client.contact.service;

import com.dh.chat.contact.service.input.ContactCreateInput;
import com.dh.fullstack.users.service.client.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Service
public class SystemContactService {

    @Autowired
    private ModuleContactClient client;

    public Contact createContact(ContactCreateInput input) {
        return client.createContact(input);
    }
}
