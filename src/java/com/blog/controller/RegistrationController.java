package com.blog.controller;

import com.blog.model.CountryDAO;
import com.blog.model.User;
import com.blog.model.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    
    @Autowired
    UserDAO userDAO;
    @Autowired
    CountryDAO countryDAO;
   
     
     
    
    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String getRegistration(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("countries",countryDAO.getAll());
        return "registration";
    }
    
@RequestMapping(value="/registration",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user,BindingResult result,Model model){
        if(result.hasErrors()){
             model.addAttribute("countries",countryDAO.getAll());
            return "registration";
        }
        userDAO.saveUser(user);
        
        return "success";
    }
}
