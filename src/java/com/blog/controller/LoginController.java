package com.blog.controller;

import com.blog.model.User;
import com.blog.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    
    @Autowired
    UserDAO userDAO;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String getLogin(){
    
        return "login";
    }
    
     @RequestMapping(value="/login", method=RequestMethod.POST)
    public String postIndex(@RequestParam("userEmail")String email,@RequestParam("userPassword")String password, ModelMap model){
  
        User user = userDAO.getUserByEmail(email);
        System.out.println("user" + user);
        if (user == null) {
            model.addAttribute("emailError", "Pogresan e-mail");
            return "login";
        }else if(user.getPassword().equals(password)){
            return "index";
        }else{
            model.addAttribute("passwordError", "Pogresna sifra");
            return "login";
        }

    }
    
}
