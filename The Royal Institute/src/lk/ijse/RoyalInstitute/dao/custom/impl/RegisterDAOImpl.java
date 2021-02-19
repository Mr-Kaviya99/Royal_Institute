package lk.ijse.RoyalInstitute.dao.custom.impl;

import lk.ijse.RoyalInstitute.dao.custom.RegisterDAO;
import lk.ijse.RoyalInstitute.entity.Register;
import lk.ijse.RoyalInstitute.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean add(Register entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Serializable save = session.save(entity);

        transaction.commit();

        session.close();

        return true;
    }

    @Override
    public boolean delete(Register entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Register entity) throws Exception {
        return false;
    }

    @Override
    public List<Register> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Query from_register = session.createQuery("from Register ");

        List<Register> list = from_register.list();

        transaction.commit();

        session.close();

        return list;
    }

    @Override
    public Register getOne(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Register register = session.get(Register.class, s);

        transaction.commit();

        session.close();

        return register;
    }
}
