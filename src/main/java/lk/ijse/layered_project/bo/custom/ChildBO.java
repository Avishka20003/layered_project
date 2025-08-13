package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Child;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ChildBO extends SuperBO {

    public ArrayList<Child> getAll() throws SQLException, ClassNotFoundException ;


    public boolean save(Child dto) throws SQLException, ClassNotFoundException ;


    public boolean update(Child dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
}
