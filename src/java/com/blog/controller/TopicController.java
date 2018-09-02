package com.blog.controller;

import com.blog.model.TopicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicController {
    
    @Autowired
    TopicDAO topicDAO;
    
    @RequestMapping(value="/topic/{category}/{name}")
    public String readTopic(@PathVariable String category, @PathVariable String name){
    
        
        return "readtopic";
    }
    
}
