package lk.ijse.RoyalInstitute.business;

import lk.ijse.RoyalInstitute.business.custom.impl.CourseBOImpl;
import lk.ijse.RoyalInstitute.business.custom.impl.RegisterBOImpl;
import lk.ijse.RoyalInstitute.business.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;


    private BOFactory(){

    }

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTER:
                return (T) new RegisterBOImpl();
            default:
                return null;
        }
    }
}
