package lk.ijse.RoyalInstitute.util;

import lk.ijse.RoyalInstitute.entity.Course;
import lk.ijse.RoyalInstitute.entity.Register;
import lk.ijse.RoyalInstitute.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Properties properties=new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("RoyalInstitute.properties"));
            sessionFactory = new Configuration().mergeProperties(properties)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Register.class)
                    .buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static FactoryConfiguration getInstance(){
        return (null == factoryConfiguration) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}

