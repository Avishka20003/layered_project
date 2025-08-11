package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.custom.DoctorDAO;
import lk.ijse.layered_project.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public ArrayList<Doctor> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Doctor customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Doctor customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public Doctor search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
