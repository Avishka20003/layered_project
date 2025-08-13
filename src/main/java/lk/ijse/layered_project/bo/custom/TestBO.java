package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TestBO extends SuperBO {
    public ArrayList<Test> getAll() throws SQLException, ClassNotFoundException ;

    public boolean save(Test dto) throws SQLException, ClassNotFoundException ;

    public boolean update(Test dto) throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;
}
