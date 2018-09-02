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
        
        //ukoliko forma nije validna vraca registraciju sa ispisanim greskama
        if(result.hasErrors()){
             model.addAttribute("countries",countryDAO.getAll());
            return "registration";
        }
        
        
        //ukoliko su svi inputi validni proverava se da li korisnik sa unetim emailom i usernameom vec postji ukoliko postoji vraca
        //registration view sa error porukom
        
        if((userDAO.userNameisValid(user.getUserName())) && (userDAO.emailIsValid(user.getEmail()))){
          
            userDAO.saveUser(user);
          
            return "success";
           
          
        }else{
            if(! (userDAO.userNameisValid(user.getUserName()))){
                 model.addAttribute("userNameExists","Korisnik sa unetim korisnickim imenom vec postoji");
            }
            if(! (userDAO.emailIsValid(user.getEmail()))){
                 model.addAttribute("emailExists","Korisnik sa unetom email adresom vec postoji");
            }
            
            return "registration";
        }
    
  
    }
}
