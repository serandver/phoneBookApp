package com.app.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = {"/" ,"/index"})
    public String getStartPage(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String getSignInPage(){
        return "login";
    }

    @GetMapping(value = "/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @GetMapping(value = {"/phonebook"})
    public String getContacts(){
        return "phonebook";
    }

    @GetMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping(value="/403")
    public String Error403(){
        return "403";
    }
}
