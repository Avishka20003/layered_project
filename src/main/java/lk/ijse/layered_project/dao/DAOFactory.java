package lk.ijse.layered_project.dao;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return (daoFactory==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
        CHILD,CLINIC,EMPLOYEE,FATHER,MOTHER,SESSION,TEST


    }
  /*  public SuperDAO getDAO(DAOTypes daoType) {
        switch(daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }*/
}
