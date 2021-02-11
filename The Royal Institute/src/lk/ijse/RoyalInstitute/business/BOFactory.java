package lk.ijse.RoyalInstitute.business;

public class BOFactory {

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT :
                return (T) StudentBOImpl();
            default:
                return null
        }
    }

}
