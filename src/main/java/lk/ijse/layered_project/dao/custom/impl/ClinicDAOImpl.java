package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.ClinicDAO;
import lk.ijse.layered_project.dto.ClinicDto;
import lk.ijse.layered_project.entity.Clinic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicDAOImpl implements ClinicDAO {
    public boolean save(Clinic clinic) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO clinic (clinic_name,location,description,contact) VALUES (?,?,?,?)";
        boolean isInsert = SQLUtil.executeUpdate(sql, clinic.getClinic_name(), clinic.getClinic_location(), clinic.getDescription(), clinic.getContact());
        return isInsert;
    }

    public boolean Delete(String clinicId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM clinic WHERE clinic_id=?";
        boolean isDelete = SQLUtil.executeUpdate(sql,clinicId);
        return isDelete;
    }

    public ArrayList<Clinic> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM clinic";
        ResultSet resultSet = SQLUtil.executeQuery(sql);
        ArrayList<Clinic> clinic = new ArrayList<>();
        while (resultSet.next()) {
            Clinic clinics = new Clinic(
                    resultSet.getInt("clinic_id"),
                    resultSet.getString("clinic_name"),
                    resultSet.getString("location"),
                    resultSet.getString("description"),
                    resultSet.getString("contact"),
                    resultSet.getString("status")

            );
            clinic.add(clinics);

        }
        return clinic;
    }

    public boolean update(Clinic clinic) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE clinic SET clinic_name=?,location=?,description=?,contact=? WHERE clinic_id=?";
        boolean isUpdated = SQLUtil.executeUpdate(sql , clinic.getClinic_name(),clinic.getClinic_location(),clinic.getDescription(),clinic.getContact(),clinic.getClinic_id());
        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM clinic WHERE clinic_id=? " , id);
    }
}

