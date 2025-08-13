package lk.ijse.layered_project.bo.custom.impl;


import lk.ijse.layered_project.bo.custom.ClinicBO;
import lk.ijse.layered_project.entity.Clinic;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicBOImpl implements ClinicBO {
    @Override
    public ArrayList<Clinic> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Clinic dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Clinic dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
