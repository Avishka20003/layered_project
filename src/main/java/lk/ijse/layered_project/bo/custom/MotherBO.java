package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Mother;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MotherBO extends SuperBO {
    public ArrayList<Mother> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(Mother dto) throws SQLException, ClassNotFoundException;

    public boolean update(Mother dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}