package lk.ijse.layered_project.dao.custom.impl;


import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.EmployeeDAO;
import lk.ijse.layered_project.dto.CashierDto;
import lk.ijse.layered_project.dto.DoctorDto;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.dto.MidwifeDto;
import lk.ijse.layered_project.entity.Employee;

import javax.crypto.MacSpi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee (name, contact_number, address, role, specialist, status, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getPassword());
}

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        if (dto.getPassword() != null) {
            String sql = "UPDATE Employee SET name = ?, contact_number = ?, address = ?, role = ?, specialist = ?, status = ?, password = ? WHERE employee_id = ?";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getPassword(), dto.getEmployeeId());
        } else {
            String sql = "UPDATE Employee SET name = ?, contact_number = ?, address = ?, role = ?, specialist = ?, status = ? WHERE employee_id = ?";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getEmployeeId());
        }
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Employee WHERE employee_id = ?", id);
    }
}
