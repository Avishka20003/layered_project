package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.SessionBO;
import lk.ijse.layered_project.entity.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public class SessionBOImpl implements SessionBO {
    @Override
    public ArrayList<Session> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Session dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Session dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
