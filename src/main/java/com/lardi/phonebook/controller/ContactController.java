package com.lardi.phonebook.controller;


import com.lardi.phonebook.entity.Contact;
import com.lardi.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller(value = "/")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping({"/index", "/"})
    public String listContacts(Map<String, Object> map) {

        map.put("contact", new Contact());
        map.put("contactList", contactService.getAllContacts());

        return "phonebook";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact,
                             BindingResult result) {

        contactService.addContact(contact);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        contactService.deleteContact(contactId);

        return "redirect:/index";
    }
}
