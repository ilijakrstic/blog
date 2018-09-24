package com.blog.model;

import com.blog.model.Topic;
import com.blog.model.Topic;
import com.blog.model.User;
import com.blog.model.User;
import java.io.Serializable;
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
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CommentsDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<Comments> getCommentsByTopic(String topicId,int offset,int maxresult) {

        Session session = sessionFactory.openSession();

        List<Comments> comments = session.getNamedQuery("Comments.findAll").setString("topicID", topicId).setFirstResult(offset).setMaxResults(maxresult).list();

        return comments;
    }

    public Comments addComment(String text, User user, Topic topic) {
        Session session = sessionFactory.getCurrentSession();
        Comments comment = new Comments();
        comment.setCommentText(text);
        comment.setCommentTime(new Date());
        comment.setTopic(topic);
        comment.setUsers(user);

        session.save(comment);

        return comment;
    }

    public Comments getCommentById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Comments) session.get(Comments.class, id);
    }

}
