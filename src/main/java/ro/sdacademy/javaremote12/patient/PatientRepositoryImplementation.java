package ro.sdacademy.javaremote12.patient;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ro.sdacademy.javaremote12.SessionCreation;

import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImplementation implements PatientRepository {

    @Override
    public Integer createPatient(PatientEntity patient) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
           //metoda save returneaza ID-ul inregistrarii in baza de date
             Integer patientId = (Integer) session.save(patient);
            //session.save(patient);
            transaction.commit();
            session.close();
            return patientId;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public void updatePatient(PatientEntity patient) {
        Session session = SessionCreation.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(patient);
        transaction.commit();
        session.close();
    }

    @Override
    public List<PatientEntity> getAllPatients() {
        List<PatientEntity> patientList = new ArrayList<>();
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            Query query = session.createQuery("from PatientEntity", PatientEntity.class);
            patientList = query.list();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return patientList;
    }

    @Override
    public void deletePatient(Integer id) {
        try {
            Session session = SessionCreation.getSessionFactory().openSession();
            PatientEntity patient = session.find(PatientEntity.class, id);
            Transaction transaction = session.beginTransaction();
            session.delete(patient);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public PatientEntity getPatientById(Integer id) throws Exception {
        PatientEntity patient = null;

        Session session = SessionCreation.getSessionFactory().openSession();
        patient = session.find(PatientEntity.class, id);
        if (patient == null) {
            throw new Exception("The patient with id: " + id + " does not exist in the database");
        } else {
            session.close();
            return patient;
        }
    }
}
