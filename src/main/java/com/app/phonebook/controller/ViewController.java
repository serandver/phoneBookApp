package com.app.phonebook.controller;

import com.app.phonebook.model.User;
import com.app.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/" ,"/index"})
    public String getStartPage(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST   )
    public String getSignInPage(){
        return "login";
    }



    @RequestMapping(value = "/signup", method = { RequestMethod.GET })
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);

        return "redirect:/phonebook";
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
