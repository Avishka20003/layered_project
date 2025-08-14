package lk.ijse.layered_project.bo;

import lk.ijse.layered_project.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory == null) ? new BOFactory() : boFactory;
    }
    public enum BOTypes{
        CHILD,CLINIC,EMPLOYEE,FATHER,MOTHER,SESSION,TEST,FAMILY,DOCTOR,MIDWIFE
    }
    public SuperBO getBO(BOTypes boType) {
        switch(boType){
            case CHILD:
                return new ChildBOImpl();

            case CLINIC:
                return new ClinicBOImpl();

            case FATHER:
                return new FatherBOImpl();

            case MOTHER:
                return new MotherBOImpl();

           case SESSION:
                return new SessionBOImpl();

           case TEST:
                return new TestBOImpl();

                case FAMILY:
                    return new FamilyBOImpl();

                    case DOCTOR:
                        return new DoctorBOImpl();

                        case MIDWIFE:
                            return new MidwifeBOImpl();

            default:
                return null;
        }
    }
}
