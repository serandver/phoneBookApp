package com.lardi.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @RequestMapping(value = {"/" ,"/index"}, method = RequestMethod.GET)
    public String getStartPage(){
        return "index";
    }

    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public String getSignInPage(){
        return "signin";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String getSignUpPage(){
        return "signup";
    }

    @RequestMapping(value = {"/phonebook"}, method = RequestMethod.GET)
    public String getContacts(){
        return "phonebook";
    }

}
