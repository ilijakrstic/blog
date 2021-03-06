package com.blog.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class TopicDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public static int ukupnoPodataka = 0;
    
    public List getBlogTopic(int startPage){
        
        Session session = sessionFactory.getCurrentSession();
        List list;
        Criteria cr = session.createCriteria(Topic.class).add(Restrictions.eq("category", "blog")).addOrder(Order.desc("publish_date"));
        list = cr.list();
        ukupnoPodataka = list.size();
        
        cr.setFirstResult((startPage-1)*9);
        cr.setMaxResults(9);
       
        list = cr.list();
        
         System.out.println(list.size() + "velicina");
        
        return list;
        
    }
    
    public Topic getTopicById(String id){
        
        Session session = sessionFactory.getCurrentSession();
        
        Topic topic =  (Topic) session.getNamedQuery("Topic.findById").setString("id", id).uniqueResult();
        
        return topic;
        
    }
    
    public List getTopicByCategory(String category){
        
        Session session = sessionFactory.getCurrentSession();
        
        List list = session.getNamedQuery("Topic.findByCategory").setString("category", category).list();
        
        return list;
        
    }
    
    public List getTopicBySubCategory(String subCategory, int startPage){
        
        Session session = sessionFactory.getCurrentSession();
        System.out.println(startPage + " " + subCategory);
        
        List list;
        Criteria cr = session.createCriteria(Topic.class).add(Restrictions.eq("subCategory", subCategory));
        list = cr.list();
        ukupnoPodataka = list.size();
        
        cr.setFirstResult((startPage-1)*9);
        cr.setMaxResults(9);
       
        list = cr.list();
        
        return list;
        
    }
    
    
    //metoda za povezane clanke
    
    public List<Topic> getReleatedTopics(String subCategory,String topicId){
        Session session = sessionFactory.getCurrentSession();
        
        List<Topic> topics = (List<Topic>) session.getNamedQuery("Topic.findBySubCategory").setString("subCategory", subCategory).setString("topicId", topicId).setMaxResults(3).list();
        
        return topics;
    }
    
    
    
}
