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

}
