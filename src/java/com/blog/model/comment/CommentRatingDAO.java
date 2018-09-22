package com.blog.model.comment;

import com.blog.model.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CommentRatingDAO {

    @Autowired
    SessionFactory sessionFactory;

    public CommentRating insertLike(Comments comm, User user, int like) {
        Session session = sessionFactory.getCurrentSession();
        CommentRating commRating = new CommentRating();
        commRating.setUser(user);
        commRating.setComment(comm);

        switch (like) {
            case 1:
                commRating.setLike(1);
                break;
            case -1:
                commRating.setLike(-1);
                break;
            default:
                commRating.setLike(0);
                break;
        }

        commRating.setRating_time(new Date());

        return (CommentRating) session.save(commRating);

    }

}
