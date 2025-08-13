package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.DoctorBO;
import lk.ijse.layered_project.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorBOImpl implements DoctorBO {
    @Override
    public ArrayList<Doctor> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Doctor dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Doctor dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
