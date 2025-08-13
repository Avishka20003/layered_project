package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.FatherBO;
import lk.ijse.layered_project.entity.Father;

import java.sql.SQLException;
import java.util.ArrayList;

public class FatherBOImpl implements FatherBO {
    @Override
    public ArrayList<Father> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Father dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Father dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
