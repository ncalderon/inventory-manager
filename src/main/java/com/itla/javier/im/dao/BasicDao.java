package com.itla.javier.im.dao;

import com.itla.javier.im.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Javier on 11/29/2015.
 */
public class BasicDao<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Class entityClass;

    public BasicDao(Class entityClass) {
        this.entityClass = entityClass;
    }


    public T get (Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        T entity = null;
        try {
            entity = (T)session.get(entityClass, id);
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;

    }

    public List<T> get (String query) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<T> entities = null;
        try {
            entities = session.createCriteria(entityClass).list();
            //entities = session.createQuery(query).list();
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entities;
    }

    public T add (T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }catch (Exception ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    public T update (T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }catch (Exception ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    public void delete (long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(session.get(entityClass, id));
            tx.commit();
        }catch (Exception ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
