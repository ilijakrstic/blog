
package com.blog.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class CountryDAO {
    
     @Autowired
    SessionFactory sessionFactory;
     public List<Country> getAll(){
         Session session = sessionFactory.getCurrentSession();
         List countries = session.getNamedQuery("Country.findAll").list();
         return countries;
    }
}
