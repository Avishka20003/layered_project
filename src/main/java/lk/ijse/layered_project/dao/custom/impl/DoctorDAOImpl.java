package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.DoctorDAO;
import lk.ijse.layered_project.dto.DoctorDto;
import lk.ijse.layered_project.entity.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorDAOImpl implements DoctorDAO  {


    public boolean save(Doctor doctor) throws SQLException, ClassNotFoundException{
        return SQLUtil.executeUpdate(
                "INSERT INTO Employee (name, contact_number, address, role, specialist, status) VALUES (?,?,?,?,?,?)",
                doctor.getName(), doctor.getContact(), doctor.getAddress(), "Doctor", doctor.getSpecialist(), doctor.getStatus()
        );
    }

    public boolean update(Doctor doctor)throws SQLException, ClassNotFoundException{
        return SQLUtil.executeUpdate(
                "UPDATE Employee SET name=?, contact_number=?, address=?, specialist=?, status=? WHERE employee_id=? AND role='Doctor'",
                doctor.getName(), doctor.getContact(), doctor.getAddress(), doctor.getSpecialist(), doctor.getStatus(), doctor.getId()
        );
    }

    public boolean delete(int id)throws SQLException, ClassNotFoundException{
        return SQLUtil.executeUpdate("DELETE FROM Employee WHERE employee_id=? AND role='Doctor'", id);
    }

    public ArrayList<Doctor> getAll()throws SQLException, ClassNotFoundException{
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Employee WHERE role='Doctor'");
        ArrayList<Doctor> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Doctor(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact_number"),
                    rs.getString("specialist"),
                    rs.getString("status")
            ));
        }
        return list;
    }

}
