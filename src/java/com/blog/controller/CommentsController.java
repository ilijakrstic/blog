package com.blog.controller;

import com.blog.model.Comments;
import com.blog.model.CommentsDAO;
import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import com.blog.model.User;
import com.blog.model.UserDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nrack
 */
@Controller
public class CommentsController {

    @Autowired
    CommentsDAO commentsDAO;
    @Autowired
    TopicDAO topicDAO;
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/topic/{id}")
    public String getTopicByID(Model model, @PathVariable String id) {

        List<Comments> comments = commentsDAO.getCommentsByTopic(id);

        model.addAttribute("comments", comments);

        Topic topic = topicDAO.getTopicById(id);

        model.addAttribute("topic", topic);

        return "demoTopicComments";
    }



}
