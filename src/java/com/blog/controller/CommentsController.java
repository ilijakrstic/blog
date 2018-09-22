package com.blog.controller;

import com.blog.model.comment.Comments;
import com.blog.model.comment.CommentsDAO;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import com.blog.model.User;
import com.blog.model.UserDAO;
import com.blog.model.ajax.AjaxResponseBody;
import com.blog.model.comment.CommentRating;
import com.blog.model.comment.CommentRatingDAO;
import com.blog.model.comment.PostComment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
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
    @Autowired
    CommentRatingDAO commentRatingDAO;

    @RequestMapping(value = "/topic/{id}", method = RequestMethod.GET)
    public String getTopicByID(Model model, @PathVariable String id, @CookieValue(value = "userid", defaultValue = "0") String userid) {

        List<Comments> comments = commentsDAO.getCommentsByTopic(id);
        
        
       

        model.addAttribute("comments", comments);
        

        Topic topic = topicDAO.getTopicById(id);

        model.addAttribute("topic", topic);
        model.addAttribute("style", "comment");
        return "demoTopicComments";
    }

    @RequestMapping(value = "/ajaxcall/postcomment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostComment> postTopic(@RequestBody PostComment comment, Model model, @CookieValue(value = "userid") String userid) throws JsonProcessingException {

        Topic topic = topicDAO.getTopicById(comment.getTopicId());
        System.out.println(comment.getUserId());
      
      
        String commentText = comment.getText();

        Comments comm = commentsDAO.addComment(commentText, userDAO.getUserById(Integer.valueOf(userid)), topic);

        comment.setTime(comm.getCommentTimePassed());
        comment.setUsername(comm.getUsers().getUserName());
        comment.setUserphoto(comm.getUsers().getPicture());
        comment.setCommentId(comm.getComment_id());

        ObjectMapper mapper = new ObjectMapper();

        String response = mapper.writeValueAsString(comment);

        return new ResponseEntity<PostComment>(comment, HttpStatus.OK);
    }

    //insert like or dislike
    @RequestMapping(value = "/ajaxcall/postlike", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void postLike(@RequestParam("like") int like, @RequestParam("commId") String commId,@ModelAttribute("user") User user) {

      //    System.out.println(user);

//        Comments comm = commentsDAO.getCommentById(Integer.valueOf(commId));
//
//        if (like > 1 || like < -1) {
//            return new ResponseEntity<String>("bad request", HttpStatus.BAD_REQUEST);
//        }
//
//        CommentRating commRating = commentRatingDAO.insertLike(comm, user, like);
//
//        return new ResponseEntity<Integer>(commRating.getLike(), HttpStatus.OK);

    }
}
