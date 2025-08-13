package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.FatherDAO;
import lk.ijse.layered_project.dto.FatherDto;
import lk.ijse.layered_project.entity.Father;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FatherDAOImpl implements FatherDAO {
    public boolean save(Father father) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO father (name, address, nic, dob, occupation, email, phone_number, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return SQLUtil.executeUpdate(sql,
                father.getName(),
                father.getAddress(),
                father.getNic(),
                father.getDob(),
                father.getOccupation(),
                father.getEmail(),
                father.getPhone_number(),
                father.getBlood_type()
        );
    }

    public boolean update(Father father) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE father SET name=?, address=?, nic=?, dob=?, occupation=?, email=?, phone_number=?, blood_type=? " +
                "WHERE father_id=?";
        return SQLUtil.executeUpdate(sql,
                father.getName(),
                father.getAddress(),
                father.getNic(),
                father.getDob(),
                father.getOccupation(),
                father.getEmail(),
                father.getPhone_number(),
                father.getBlood_type(),
                father.getFather_id()
        );
    }

    public boolean delete(int fatherId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM father WHERE father_id=?";
        return SQLUtil.executeUpdate(sql, fatherId);
    }

    public ArrayList<Father> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM father";
        ResultSet resultSet = SQLUtil.executeQuery(sql);
        ArrayList<Father> fatherList = new ArrayList<>();

        while (resultSet.next()) {
            Father father = new Father(
                    resultSet.getInt("father_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("dob"),
                    resultSet.getString("occupation"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("blood_type")
            );
            fatherList.add(father);
        }

        return fatherList;
    }
    public ArrayList<String> getAllFatherById( ) throws SQLException, ClassNotFoundException {
        ArrayList<String> fatherList = new ArrayList<>();
        ResultSet resultSet = SQLUtil.executeQuery("select * from father");
        while (resultSet.next()) {
            fatherList.add(resultSet.getString("father_id"));
        }

        return fatherList;



    }

}
