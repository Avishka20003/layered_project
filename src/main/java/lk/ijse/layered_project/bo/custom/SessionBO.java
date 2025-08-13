package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.entity.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SessionBO extends SuperBO {
    public ArrayList<Session> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(Session dto) throws SQLException, ClassNotFoundException;

    public boolean update(Session dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}