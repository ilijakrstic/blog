package com.blog.controller;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    
    @Autowired
    TopicDAO topicDAO;
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String getIndex(@RequestParam(value = "page", defaultValue = "1")int Page,ModelMap modelMap){
        
        List blogTopicList = topicDAO.getBlogTopic();
        
        modelMap.addAttribute("blogTopicList", blogTopicList);
        
        Topic top = (Topic)blogTopicList.get(0);
        System.out.println(top.toString());
        return "index";
    }
    
   
    
}
