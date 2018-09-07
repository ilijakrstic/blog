package com.blog.controller;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopicController {
    
    @Autowired
    TopicDAO topicDAO;
    
    @RequestMapping(value="/topic/{category}/{subcategory}/{id}")
    public String readTopic(@PathVariable String id,@PathVariable String subcategory ,Model model){
    
        
        Topic topic = topicDAO.getTopicById( id);
        List<Topic> releatedTopics = topicDAO.getReleatedTopics(subcategory,id);
        model.addAttribute("topic",topic);
        model.addAttribute("releatedTopics",releatedTopics);
        model.addAttribute("style","readtopic");
        
        return "readtopic";
    }
    
    @RequestMapping(value="/topic/newtopic", method=RequestMethod.GET)
    public String newTopicGET(Model model){
    
        
        
        return "newtopic";
    }
    
    @RequestMapping(value="/topic/newtopic", method=RequestMethod.POST)
    public String newTopicPOST(Model model,
            @RequestParam(value="title")String title,
            @RequestParam(value="category")String category,
            @RequestParam(value="subcategory")String subCategory,
            @RequestParam(value="description")String description,
            @RequestParam(value="content")String content,
            @RequestParam(value="author")String author){
        
        
        System.out.println(title + " " + author);
    
        
        
        return "newtopic";
    }
    
}
