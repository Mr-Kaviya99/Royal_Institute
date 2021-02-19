package lk.ijse.RoyalInstitute.dao;

import lk.ijse.RoyalInstitute.dao.custom.impl.CourseDAOImpl;
import lk.ijse.RoyalInstitute.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.RoyalInstitute.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO > T getDAO(DAOType  daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case REGISTER:
                return (T) new RegisterDAOImpl();
            default:
                return null;
        }
    }

}
