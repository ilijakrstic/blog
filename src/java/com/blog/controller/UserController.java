
package com.blog.controller;

import com.blog.model.User;
import com.blog.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    
    @Autowired
    UserDAO userDAO;
    
    @RequestMapping(value = "/user/{username}")
    public String getUserProfile(Model model, @PathVariable String username) {

        User user = userDAO.getUserByUserName(username);

        if (user != null) {
            model.addAttribute("user", user);

            model.addAttribute("style", "userprofile");

            return "userprofile";
        }
        
        return "index";
    }
    
    
    
}
