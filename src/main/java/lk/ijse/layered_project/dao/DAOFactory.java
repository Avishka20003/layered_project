package lk.ijse.layered_project.dao;

import lk.ijse.layered_project.bo.custom.impl.*;
import lk.ijse.layered_project.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return (daoFactory==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
        CHILD,CLINIC,DOCTOR,EMPLOYEE,FATHER,MOTHER,SESSION,TEST,MIDWIFE,CASHIER,FAMILY


    }
    public SuperDAO getDAO(DAOTypes daoType) {
        switch(daoType){
            case CHILD:
                return new ChildDAOImpl();

            case CLINIC:
                return new ClinicDAOImpl();

                case DOCTOR:
                    return new DoctorDAOImpl();

            case FATHER:
                return new FatherDAOImpl();

            case MOTHER:
                return new MotherDAOImpl();

            case SESSION:
                return new SessionDAOImpl();

            case TEST:
                return new TestDAOImpl();

                case MIDWIFE:
                    return new MidwifeDAOImpl();

                    case CASHIER:
                        return new CashierDAOImpl();

                        case EMPLOYEE:
                            return new EmployeeDAOImpl();

            case FAMILY:
                return new FamilyDAOImpl();

            default:
                return null;
        }
    }
}
