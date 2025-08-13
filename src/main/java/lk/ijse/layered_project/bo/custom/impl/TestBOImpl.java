package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.TestBO;
import lk.ijse.layered_project.entity.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestBOImpl implements TestBO {
    @Override
    public ArrayList<Test> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Test dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Test dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
