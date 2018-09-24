package com.blog.model.comment;

import com.blog.model.Topic;
import com.blog.model.User;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c where c.topic.id  = :topicID ORDER BY c.commentTime DESC")})
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int comment_id;

    //user strani kljuc
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //topic strani kljuc
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    //ostale kolone u comments
    @Column(name = "text")
    @Size(min=1,message = "polje za komentar ne moze biti prazno!")
    private String commentText;

    @Column(name = "comment_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;
    
    @OneToMany(mappedBy = "comment")
    List<CommentRating> commentRatings;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {

        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

      public String getCommentTimePassed() {
        
        //trenutno vreme
        Date now = new Date();
        
        //vreme komentara
        Date commTime = this.getCommentTime();

        //razlika izmedju treuntnog vremena i vremena komentara u milisekundama
        long differenceMillies = Math.abs(now.getTime() - commTime.getTime());

        StringBuilder poruka = new StringBuilder();
        poruka.append("pre ");

        //ukoliko je komentar objvaljen pre manje od jednog minuta
        if (TimeUnit.MINUTES.convert(differenceMillies, TimeUnit.MILLISECONDS) < 1) {
            return "upravo sada";
        }

        //ukoliko je komentar objavljen pre manje od jednog sata i vise od jednog minuta
        if (TimeUnit.MINUTES.convert(differenceMillies, TimeUnit.MILLISECONDS) >= 1 && TimeUnit.HOURS.convert(differenceMillies, TimeUnit.MILLISECONDS) < 1) {
            long minutes = TimeUnit.MINUTES.convert(differenceMillies, TimeUnit.MILLISECONDS);
  
            poruka.append(minutes);
            poruka.append(" minuta");
            return poruka.toString();
        }

        //ukoliko je komentar objavljen pre manje od jednog dana i vise od jednog sata
        if (TimeUnit.HOURS.convert(differenceMillies, TimeUnit.MILLISECONDS) >= 1 && TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) < 1) {
            long hours = TimeUnit.HOURS.convert(differenceMillies, TimeUnit.MILLISECONDS);
            poruka.append(hours);
            poruka.append(" sata");
            return poruka.toString();
        }

        //ukoliko je komentar objavljen pre manje od jednog meseca i vise od jednog dana
        if (TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) >= 1 && TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) <= 31) {
            long days = TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS);
            poruka.append(days);
            poruka.append(" dana");
            return poruka.toString();
        }

        //ukoliko je komentar objavljen pre manje od jedne godine i vise od jednog meseca
        if (TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) > 31 && TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) <= 366) {
            long days = TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS);
            int months = (int) Math.floor(days / 30);

            poruka.append(months);

            poruka.append(" meseca");

            return poruka.toString();
        }

        //ukoliko je komentar objavljen pre manje od jedne godine i vise od jednog meseca
        if (TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS) > 366) {
            long days = TimeUnit.DAYS.convert(differenceMillies, TimeUnit.MILLISECONDS);
            int years = (int) Math.floor(days / 366);

            poruka.append(years);
            poruka.append(" godina");

            return poruka.toString();
        }

        return poruka.toString();

    }
    

}
