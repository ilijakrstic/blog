package com.blog.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDAO {

    static User user = null;
    static List list;

    public static User getUserById(int id) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List list = session.createCriteria(User.class).add(Restrictions.eq("id", id)).list();

            if (!list.isEmpty()) {
                user = (User) list.get(0);
            }
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return user;

    }

    public static User getUserByEmail(String email) {

        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            list = session.createCriteria(User.class).add(Restrictions.eq("email", email)).list();
            System.out.println(list.size());
            if (!list.isEmpty()) {
                user = (User)list.get(0);
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
        
        

        return user;

    }

}
