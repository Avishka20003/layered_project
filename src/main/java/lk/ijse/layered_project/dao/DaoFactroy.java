package lk.ijse.layered_project.dao;


public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return (daoFactory==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
        DOCTOR

    }
    public SuperDAO getDAO(DAOTypes daoType) {
        switch (daoType) {
            case DOCTOR:
                return new CustomerDAOImpl();

            default:
                return null;
        }
    }
}



