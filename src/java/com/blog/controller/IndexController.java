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
    
    List blogTopicList = null;
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String getIndex(@RequestParam(value = "page", defaultValue = "1")int page,@RequestParam(value="subcategory", required=false) String subcategory ,ModelMap modelMap){
        
        if(subcategory == null){
             blogTopicList = topicDAO.getBlogTopic(page);
        }else{
            System.out.println(subcategory);
             blogTopicList = topicDAO.getTopicBySubCategory(subcategory);
        }
        
        
        
        int totalPage = (int) Math.ceil((double)topicDAO.ukupnoPodataka / 9);
        int endpage;
        int startpage = page;
     
        
        endpage = (page + 2) > totalPage? totalPage : page + 2;
        
        
        
        if ((page - 2) <= 0)
            startpage = 1; 
        else
            startpage -= 2;
        
        modelMap.addAttribute("blogTopicList", blogTopicList);
        modelMap.addAttribute("startpage", startpage);
        modelMap.addAttribute("endpage", endpage);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("topicList", blogTopicList);
        
      
    
        return "index";
    }
    
   
    
}
