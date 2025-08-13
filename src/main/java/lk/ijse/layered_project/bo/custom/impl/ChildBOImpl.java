package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.ChildBO;
import lk.ijse.layered_project.entity.Child;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChildBOImpl implements ChildBO {
    @Override
    public ArrayList<Child> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Child dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Child dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
