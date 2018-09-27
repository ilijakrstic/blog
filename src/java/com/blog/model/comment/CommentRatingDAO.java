package com.blog.model.comment;

import com.blog.model.Comments;
import com.blog.model.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.SessionStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CommentRatingDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void insertLike(Comments comm, User user, int like) {
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

        session.save(commRating);

    }

    public CommentRating updateLike(CommentRating commR, int like) {
        Session session = sessionFactory.getCurrentSession();
        commR.setLike(like);
        return (CommentRating) session.merge(commR);

    }

    public CommentRating isAlredyLikedByUser(int userId, int commId, int like) {
        Session session = sessionFactory.getCurrentSession();
        CommentRating comRatings = null;
        comRatings = (CommentRating) session.getNamedQuery("CommentRating.isAlredyLiked").setInteger("userId", userId).setInteger("commId", commId).uniqueResult();

        return comRatings;
    }

    public String countRating(int commId) {
        Session session = sessionFactory.getCurrentSession();
        Long numberOfLikes = (Long) session.getNamedQuery("CommentRating.countLikes").setInteger("commId", commId).setInteger("like", 1).uniqueResult();
        Long numberOfDisslikes = (Long) session.getNamedQuery("CommentRating.countLikes").setInteger("commId", commId).setInteger("like", -1).uniqueResult();
        StringBuilder sb = new StringBuilder();
        sb.append(numberOfLikes);
        sb.append(",");
        sb.append(numberOfDisslikes);
        return sb.toString();
    }
    
   
}
