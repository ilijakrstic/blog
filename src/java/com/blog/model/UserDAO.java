package com.blog.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class UserDAO {

    
    @Autowired
    SessionFactory sessionFactory;

    public  User getUserById(int id) {

        Session session = sessionFactory.getCurrentSession();
        
        User user = (User) session.get(User.class, id);
        
        return user;

    }

    public  User getUserByEmail(String email) {

         Session session = sessionFactory.getCurrentSession();

       
         User user = (User) session.getNamedQuery("User.findByEmail").setString("email", email).uniqueResult();

        return user;

    }
    
     public  boolean emailIsValid(String email) {

         Session session = sessionFactory.getCurrentSession();

       
         User user = (User) session.getNamedQuery("User.findByEmail").setString("email", email).uniqueResult();
         if(user == null){
             return true;
         }
         
        return false;

    }
      public  boolean userNameisValid(String userName) {

         Session session = sessionFactory.getCurrentSession();

       
         User user = (User) session.getNamedQuery("User.findByUserName").setString("userName", userName).uniqueResult();
         if(user == null){
             return true;
         }
         
        return false;

    }
    
    public void saveUser(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    
    public User getUserByUserName(String username){
        
        Session session = sessionFactory.getCurrentSession();
        
        return  (User) session.getNamedQuery("User.findByUserName").setString("userName",username).uniqueResult();
          
    }
    
    public void updateUser(User user){
    
        Session session = sessionFactory.openSession();
        session.update(user);
        
        
    }
}
