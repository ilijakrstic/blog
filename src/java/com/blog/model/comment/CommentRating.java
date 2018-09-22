package com.blog.model.comment;

import com.blog.model.User;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "CommentRating.findByComment", query = "SELECT cr FROM CommentRating cr where cr.comment.comment_id  = :commentId")})
@Entity
@Table(name="comment_rating")
public class CommentRating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //korisnik koji je lajkovao
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user_comm_rating;
    
    
    //komentar koji je lajkovan
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="comment_id")
    private Comments comment;
    
    
    //0 je bez lajkova 1 je like -1 je disslike
    @Column(name="likes")
    private int likes;
    
    @Column(name="rating_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rating_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user_comm_rating;
    }

    public void setUser(User user) {
        this.user_comm_rating = user;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public int getLike() {
        return likes;
    }

    public void setLike(int like) {
        this.likes = like;
    }

    public Date getRating_time() {
        return rating_time;
    }

    public void setRating_time(Date rating_time) {
        this.rating_time = rating_time;
    }
    
    
    
}
