package lk.ijse.layered_project.dao.custom;

import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.entity.Mother;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MotherDAO extends CrudDAO<Mother> {
    public int getNextId() throws SQLException, ClassNotFoundException ;
}
