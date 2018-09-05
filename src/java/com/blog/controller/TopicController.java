package com.blog.controller;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
}
