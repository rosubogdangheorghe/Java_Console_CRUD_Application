package ro.sdacademy.javaremote12;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ro.sdacademy.javaremote12.consult.ConsultEntity;
import ro.sdacademy.javaremote12.doctor.DoctorEntity;
import ro.sdacademy.javaremote12.patient.PatientEntity;

import java.util.Properties;


public class SessionCreation {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.URL, DataBaseUtils.DB_URL);
                properties.put(Environment.USER, DataBaseUtils.DB_USER);
                properties.put(Environment.PASS, DataBaseUtils.DB_PASSWORD);
                properties.put(Environment.DRIVER, DataBaseUtils.DB_DRIVER);
                properties.put(Environment.DIALECT, DataBaseUtils.DB_DIALECT);

                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(ConsultEntity.class);
                configuration.addAnnotatedClass(DoctorEntity.class);
                configuration.addAnnotatedClass(PatientEntity.class);

                ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
                sessionFactory =configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return sessionFactory;
    }

}
