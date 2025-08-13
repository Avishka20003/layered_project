package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Clinic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClinicBO extends SuperBO {

    public ArrayList<Clinic> getAll() throws SQLException, ClassNotFoundException ;
    public boolean save(Clinic dto) throws SQLException, ClassNotFoundException ;
    public boolean update(Clinic dto) throws SQLException, ClassNotFoundException ;
    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
}
