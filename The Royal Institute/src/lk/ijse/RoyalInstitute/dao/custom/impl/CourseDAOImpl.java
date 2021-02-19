package lk.ijse.RoyalInstitute.dao.custom.impl;

import lk.ijse.RoyalInstitute.dao.custom.CourseDAO;
import lk.ijse.RoyalInstitute.entity.Course;
import lk.ijse.RoyalInstitute.entity.Student;
import lk.ijse.RoyalInstitute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean add(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.delete(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query from_course = session.createQuery("from Course ");

        List<Course> list = from_course.list();

        transaction.commit();

        session.close();

        return list;
    }

    @Override
    public Course getOne(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);

        transaction.commit();

        session.close();

        return course;
    }
}
