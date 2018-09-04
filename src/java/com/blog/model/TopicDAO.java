package com.blog.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public static int ukupnoPodataka = 0;
    
    public List getBlogTopic(int startPage){
        
        Session session = sessionFactory.openSession();
        List list = null;
        Criteria cr = session.createCriteria(Topic.class).add(Restrictions.eq("category", "blog")).addOrder(Order.desc("date"));
        list = cr.list();
        ukupnoPodataka = list.size();
        
        cr.setFirstResult((startPage-1)*9);
        cr.setMaxResults(9);
        list = cr.list();
        
         
        
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
