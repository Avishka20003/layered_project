package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.CashierDAO;
import lk.ijse.layered_project.entity.Cashier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashierDAOImpl implements CashierDAO {
    public boolean save(Cashier dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "INSERT INTO Employee (name, contact_number, address, role) VALUES (?,?,?,?)",
                dto.getName(), dto.getContact(), dto.getAddress(), "Cashier"
        );
    }

    public boolean update(Cashier dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "UPDATE Employee SET name=?, contact_number=?, address=? WHERE employee_id=? AND role='Cashier'",
                dto.getName(), dto.getContact(), dto.getAddress(), dto.getId()
        );
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Employee WHERE employee_id=? AND role='Cashier'", id);
    }

    public ArrayList<Cashier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Employee WHERE role='Cashier'");
        ArrayList<Cashier> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Cashier(
                    rs.getInt("employee_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact_number")
            ));
        }
        return list;
    }
}
