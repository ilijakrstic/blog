package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    
    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String getRegistration(){
        
        
        return "registration";
    }
}
