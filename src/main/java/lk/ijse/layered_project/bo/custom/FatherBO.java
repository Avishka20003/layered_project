package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Father;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FatherBO extends SuperBO {
    public ArrayList<Father> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(Father dto) throws SQLException, ClassNotFoundException ;

    public boolean update(Father dto) throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
}
