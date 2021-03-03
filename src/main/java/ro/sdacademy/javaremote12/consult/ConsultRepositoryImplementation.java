package ro.sdacademy.javaremote12.consult;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ro.sdacademy.javaremote12.SessionCreation;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ConsultRepositoryImplementation implements ConsultRepository {


    public void createConsult(ConsultEntity consult) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateConsult(Integer id, Double price, String diagnostic) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            ConsultEntity consult = session.find(ConsultEntity.class, id);
            consult.setPrice(price);
            consult.setDiagnostic(diagnostic);
            session.update(consult);
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<ConsultEntity> getAllConsults() {
        List<ConsultEntity> consultList = new ArrayList<>();
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            String stringQuery = "from ConsultEntity";
            Query query = session.createQuery(stringQuery, ConsultEntity.class);
            consultList = query.list();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return consultList;
    }


    public ConsultEntity getConsultById(Integer id) throws Exception {
        ConsultEntity consult;

        Session session = SessionCreation.getSessionFactory().openSession();
        consult = session.find(ConsultEntity.class, id);
        if (consult == null) {
            throw new Exception("The consult with id: " + id + " does not exist in the database");
        }
        session.close();
        return consult;
    }

    public void deleteConsult(Integer id) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            ConsultEntity consult = session.find(ConsultEntity.class, id);
            Transaction transaction = session.beginTransaction();
            session.delete(consult);
            transaction.commit();
            session.close();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
