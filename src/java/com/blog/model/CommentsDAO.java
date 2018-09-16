
package com.blog.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nrack
 */

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CommentsDAO {
    
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    
    public List<Comments>getCommentsByTopic(String topicId){
        
        Session session = sessionFactory.getCurrentSession();
        
        List<Comments> comments = session.getNamedQuery("Comments.findAll").setString("topicID",topicId).list();
        
        
        return comments;
    }
    
    public void addComment(String text,User u,Topic t){
        Session session = sessionFactory.getCurrentSession();
        Comments comment = new Comments();
        comment.setCommentText(text);
        comment.setCommentTime(new Date());
        comment.setTopic(t);
        comment.setUsers(u);
        session.save(comment);
    }
    
}
