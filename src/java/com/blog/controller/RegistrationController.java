package com.blog.controller;

import com.blog.model.User;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    
    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String getRegistration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }
    
@RequestMapping(value="/registration",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user,BindingResult result,Model model){
        if(result.hasErrors()){
            return "registration";
        }
        model.addAttribute("user",user.getCity());
        return "success";
    }
}
