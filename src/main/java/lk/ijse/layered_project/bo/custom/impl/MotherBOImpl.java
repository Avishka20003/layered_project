package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.MotherBO;
import lk.ijse.layered_project.entity.Mother;

import java.sql.SQLException;
import java.util.ArrayList;

public class MotherBOImpl implements MotherBO {
    @Override
    public ArrayList<Mother> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Mother dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Mother dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
