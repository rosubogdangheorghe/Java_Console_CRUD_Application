package ro.sdacademy.javaremote12.generics;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ro.sdacademy.javaremote12.SessionCreation;

import org.hibernate.query.Query;
import java.util.List;

public class RepositoryImplementation implements Repository<Object> {
    @Override
    public void createObject(Object object) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateObject(Object object) {
        try{
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            session.close();

        }catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Object> getAllObjects(String string, Object o) {
        List<Object> objectList;
        Session session = SessionCreation.getSessionFactory().openSession();
        Query<Object> query = session.createQuery(string, Object.class);
        objectList = query.list();
        return objectList;
    }

    @Override
    public Object getObjectById(Object o,Integer id,String string) throws Exception {
        Object object;
        Session session = SessionCreation.getSessionFactory().openSession();
        Query<Object> query = session.createQuery(string,Object.class);
        query.setParameter("idNo",id);
        object =  query.getSingleResult();
        if(object == null) {
            throw new Exception("The " + object + "with id: " + id + "does not exist in the database" );

        } else {
            session.close();
            return object;
        }
    }

    @Override
    public void deleteObject(Object object) {
        Session session = SessionCreation.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

}