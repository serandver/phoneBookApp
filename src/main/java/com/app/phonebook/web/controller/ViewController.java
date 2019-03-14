package com.app.phonebook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping(value = {"/" ,"/index"})
    public String getStartPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getSignInPage(Model model){
        return "login";
    }

    @GetMapping("/phonebook")
    public String getContacts(){
        return "phonebook";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
