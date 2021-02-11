package lk.ijse.RoyalInstitute.dao;

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
            default:
                return null;
        }
    }

}
