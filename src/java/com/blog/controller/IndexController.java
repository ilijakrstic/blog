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
    public String getIndex(@RequestParam(value = "page", defaultValue = "1")int page,ModelMap modelMap){
        
        List blogTopicList = topicDAO.getBlogTopic(page);
        
        int endpage = (int) Math.ceil((double)topicDAO.ukupnoPodataka / 5);
     
        endpage = (page + 2) > endpage? endpage : page + 2;
        
        int startpage = 0;
        
        if ((page) - 2 > 0)
            startpage =- 2;
        else
            startpage = 1; endpage+=2;
        
        modelMap.addAttribute("blogTopicList", blogTopicList);
        modelMap.addAttribute("startpage", startpage);
        modelMap.addAttribute("endpage", endpage);
        modelMap.addAttribute("kurPage", page);
        modelMap.addAttribute("topicList", blogTopicList);
        
        Topic top = (Topic)blogTopicList.get(0);
        System.out.println(top.toString());
        return "index";
    }
    
   
    
}
