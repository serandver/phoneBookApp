package com.app.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = {"/" ,"/index"})
    public String getStartPage(){
        return "index";
    }

    @RequestMapping(value = "/signin", method = { RequestMethod.GET, RequestMethod.POST })
    public String getSignInPage(){
        return "signin";
    }

    @RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
    public String getSignUpPage(){
        return "signup";
    }

    @RequestMapping(value = {"/phonebook"})
    public String getContacts(){
        return "phonebook";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}
