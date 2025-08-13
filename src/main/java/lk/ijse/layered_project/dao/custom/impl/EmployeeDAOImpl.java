package lk.ijse.layered_project.dao.custom.impl;


import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dto.CashierDto;
import lk.ijse.layered_project.dto.DoctorDto;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.dto.MidwifeDto;

import javax.crypto.MacSpi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl  {

    public boolean addEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Employee (name, contact_number, address, role, specialist, status, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getPassword());
    }

    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        if (dto.getPassword() != null) {
            String sql = "UPDATE Employee SET name = ?, contact_number = ?, address = ?, role = ?, specialist = ?, status = ?, password = ? WHERE employee_id = ?";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getPassword(), dto.getEmployeeId());
        } else {
            String sql = "UPDATE Employee SET name = ?, contact_number = ?, address = ?, role = ?, specialist = ?, status = ? WHERE employee_id = ?";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContactNumber(), dto.getAddress(), dto.getRole(), dto.getSpecialist(), dto.getStatus(), dto.getEmployeeId());
        }
    }

    public boolean addDoctor(DoctorDto dto) {
        try {
            String sql = "INSERT INTO Employee (name, contact_number, address, role, specialist) VALUES (?, ?, ?, 'Doctor', ?)";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContact(), dto.getAddress(), dto.getSpecialist());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addMidwife(MidwifeDto dto) {
        try {
            String sql = "INSERT INTO Employee (name, contact_number, address, role) VALUES (?, ?, ?, 'Midwife')";
            return SQLUtil.executeUpdate(sql, dto.getName(),dto.getContact(), dto.getAddress());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addCashier(CashierDto dto) {
        try {
            String sql = "INSERT INTO Employee (name, contact_number, address, role) VALUES (?, ?, ?, 'Cashier')";
            return SQLUtil.executeUpdate(sql, dto.getName(), dto.getContact(), dto.getAddress());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<EmployeeDto> getAllDoctors() {
        try {
            String sql = "SELECT * FROM Employee WHERE role = 'Doctor'";
            ResultSet rs = SQLUtil.executeQuery(sql);
            ArrayList<EmployeeDto> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new EmployeeDto(
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("address"),
                        rs.getString("role"),
                        rs.getString("specialist"),
                        rs.getString("status"),
                        null
                ));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<EmployeeDto> getAllMidwives() {
        try {
            String sql = "SELECT * FROM Employee WHERE role = 'Midwife'";
            ResultSet rs = SQLUtil.executeQuery(sql);
            ArrayList<EmployeeDto> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new EmployeeDto(
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("address"),
                        rs.getString("role"),
                        rs.getString("specialist"),
                        rs.getString("status"),
                        null
                ));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ArrayList<EmployeeDto> getAllCashiers() {
        try {
            String sql = "SELECT * FROM Employee WHERE role = 'Cashier'";
            ResultSet rs = SQLUtil.executeQuery(sql);
            ArrayList<EmployeeDto> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new EmployeeDto(
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("contact_number"),
                        rs.getString("address"),
                        rs.getString("role"),
                        rs.getString("specialist"),
                        rs.getString("status"),
                        null
                ));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Employee WHERE employee_id = ?", id);
    }

}
