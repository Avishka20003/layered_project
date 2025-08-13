package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.MidwifeDAO;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.dto.MidwifeDto;
import lk.ijse.layered_project.entity.Midwife;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MidwifeDAOImpl implements MidwifeDAO {

    public boolean save(Midwife dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "INSERT INTO Employee (name, contact_number, address, role) VALUES (?,?,?,?)",
                dto.getName(), dto.getContact(), dto.getAddress(), "Midwife"
        );
    }

    public boolean update(Midwife dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "UPDATE Employee SET name=?, contact_number=?, address=? WHERE employee_id=? AND role='Midwife'",
                dto.getName(), dto.getContact(), dto.getAddress(), dto.getId()
        );
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Employee WHERE employee_id=? AND role='Midwife'", id);
    }

    public ArrayList<Midwife> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Employee WHERE role='Midwife'");
        ArrayList<Midwife> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Midwife(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact_number")
            ));
        }
        return list;
    }
}
