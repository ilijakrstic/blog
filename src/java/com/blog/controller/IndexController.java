package com.blog.controller;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import com.blog.model.User;
import com.blog.model.UserDAO;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    
    @Autowired
    TopicDAO topicDAO;
    
    @Autowired
    UserDAO userDAO;
    
    List <Topic>blogTopicList = null;
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String getIndex(HttpServletRequest request,@CookieValue(value = "userid", defaultValue = "0") String userid, @RequestParam(value = "page", defaultValue = "1")int page, @RequestParam(value="subcategory", required=false) String subcategory, @RequestParam(value="userEmail",required=false)String email,@RequestParam(value="userPassword", required=false)String password,ModelMap modelMap){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
        
            modelMap.addAttribute("profileOption", "<span class=\"navbar-text\">\n" +
"                    <a href=\"/blog/user/"+user.getUserName()+"\" style=\"margin:-10px\" class=\"nav-link\">Profile</a>\n" +
"                </span>");
            
        }else{
        
            modelMap.addAttribute("profileOption", "<span class=\"navbar-text\">\n" +
"                    <a href=\"/blog/login\" style=\"margin:-10px\" class=\"nav-link\">Prijavi se</a>\n" +
"                </span>\n" +
"                <span class=\"navbar-text\">\n" +
"                    <button onclick=\"location.href='/blog/registration'\" type=\"button\" class=\"btn btn-outline-success\">Registruj se</button>\n" +
"                </span>");
            
        }
        
        
        
        if(subcategory == null){
             blogTopicList = topicDAO.getBlogTopic(page);
        }else{
             blogTopicList = topicDAO.getTopicBySubCategory(subcategory, page);
             
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
    
   @RequestMapping(value={"/", "/index"}, method=RequestMethod.POST)
   public String postIndex(HttpServletResponse response,HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1")int page, @RequestParam(value="subcategory", required=false) String subcategory, @RequestParam(value="userEmail",required=false)String email,@RequestParam(value="userPassword", required=false)String password,ModelMap modelMap){

        HttpSession session = null;
        User user = null;
        Cookie user_id = null;
        
            
        if(email != null && password != null){
            user = userDAO.getUserByEmail(email);

            if (user == null) {
                modelMap.addAttribute("emailError", "Pogresan e-mail");
                return "login";
            }else if(user.getPassword().equals(password)){
                session = request.getSession(true);
                session.setAttribute("user", user);
                user_id = new Cookie("userid", user.getUserId().toString());
                response.addCookie(user_id);

                //Kreiranje button-a za "profil"
                modelMap.addAttribute("profileOption", "<span class=\"navbar-text\">\n" +"<a href=\"/blog/user/"+user.getUserName()+"\" style=\"margin:-10px\" class=\"nav-link\">Profile</a>\n" +"</span>");


            }else{
                modelMap.addAttribute("passwordError", "Pogresan password");
                return "login";
            }
        }else{
            return "login";
        }
           
           
            

        
        if(subcategory == null){
             blogTopicList = topicDAO.getBlogTopic(page);
        }else{
             blogTopicList = topicDAO.getTopicBySubCategory(subcategory, page);
             
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
        modelMap.addAttribute("username", user.getUserName());
    
        return "index";
           
   }
} 

