package com.blog.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public List getBlogTopic(){
        
        Session session = sessionFactory.openSession();
        
        Criteria cr = session.createCriteria(Topic.class).add(Restrictions.eq("category", "blog"));
        List list = cr.list();
        
        return list;
        
    }
    
    public List getTopicByName(String name){
        
        Session session = sessionFactory.getCurrentSession();
        
        List list = session.getNamedQuery("Topic.findByName").setString("name", name).list();
        
        return list;
        
    }
    
    public List getTopicByCategory(String category){
        
        Session session = sessionFactory.getCurrentSession();
        
        List list = session.getNamedQuery("Topic.findByCategory").setString("category", category).list();
        
        return list;
        
    }
    
    public List getTopicBySubCategory(String subCategory){
        
        Session session = sessionFactory.getCurrentSession();
        
        List list = session.getNamedQuery("Topic.findByCategory").setString("subCategory", subCategory).list();
        
        return list;
        
    }
    
}
