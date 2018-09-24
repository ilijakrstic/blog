package com.blog.controller;

import com.blog.model.Comments;
import com.blog.model.CommentsDAO;

import com.blog.model.Topic;
import com.blog.model.TopicDAO;
import com.blog.model.User;
import com.blog.model.UserDAO;
import com.blog.model.ajax.AjaxResponseBody;
import com.blog.model.comment.CommentRating;
import com.blog.model.comment.CommentRatingDAO;
import com.blog.model.comment.JsonComment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
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
    public String getTopicByID(Model model, @PathVariable String id) {

        Topic topic = topicDAO.getTopicById(id);

        model.addAttribute("topic", topic);

        return "demoTopicComments";
    }

    @RequestMapping(value = "/ajaxcall/getcomments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<JsonComment> getComments(@RequestParam("offset") int offset, @RequestParam("maxresult") int maxresult, @RequestParam("topicId") String topicId
            ) {

        List<Comments> comments = commentsDAO.getCommentsByTopic(topicId, offset, maxresult);

        List<JsonComment> jsonComments = new ArrayList<>();

        for (int i = 0; i < comments.size(); i++) {
            JsonComment jsonComm = new JsonComment();
            jsonComm.setText(comments.get(i).getCommentText());
            jsonComm.setCommentId(comments.get(i).getComment_id());
            jsonComm.setTime(comments.get(i).getCommentTimePassed());
            jsonComm.setTopicId(topicId);
            jsonComm.setUserId(comments.get(i).getUsers().getUserId());
            jsonComm.setUsername(comments.get(i).getUsers().getUserName());
            jsonComm.setUserphoto(comments.get(i).getUsers().getPicture());
            jsonComments.add(jsonComm);
        }

        System.out.println(comments.size());

        return jsonComments;

    }

    @RequestMapping(value = "/ajaxcall/postcomment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonComment postTopic(@RequestParam("topicId") String topicId, @RequestParam("text") String text, @CookieValue(value = "userid", defaultValue = "0") String userid) throws JsonProcessingException {

        if (!userid.equals("0")) {
            Topic topic = topicDAO.getTopicById(topicId);

            Comments comm = commentsDAO.addComment(text, userDAO.getUserById(Integer.valueOf(userid)), topic);
            JsonComment jsonComment = new JsonComment();

            jsonComment.setTime(comm.getCommentTimePassed());
            jsonComment.setUsername(comm.getUsers().getUserName());
            jsonComment.setUserphoto(comm.getUsers().getPicture());
            jsonComment.setCommentId(comm.getComment_id());
            jsonComment.setText(text);

           return jsonComment;
        }

        else return null;

    }

    //insert like or dislike
    @RequestMapping(value = "/ajaxcall/postlike", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void postLike(@RequestParam("like") int like, @RequestParam("commId") String commId, @ModelAttribute("user") User user) {

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
