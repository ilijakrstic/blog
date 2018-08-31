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
public class IndexController {
   
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
   
    
}
