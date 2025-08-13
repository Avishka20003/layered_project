package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.ChildDAO;
import lk.ijse.layered_project.dto.ChildDto;
import lk.ijse.layered_project.entity.Child;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChildDAOImpl implements ChildDAO {

    public boolean save(Child child) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO child (mother_id, father_id, name, address, birth_place, gender, dob, birth_height, birth_weight, note, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return SQLUtil.executeUpdate(sql,
                child.getMother_id(),
                child.getFather_id(),
                child.getName(),
                child.getAddress(),
                child.getBirth_place(),
                child.getGender(),
                child.getDob(),
                child.getBirth_height(),
                child.getBirth_weight(),
                child.getNote(),
                child.getBlood_type()
        );
    }

    public boolean update(Child child) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE child SET mother_id=?, father_id=?, name=?, address=?, birth_place=?, gender=?, dob=?, birth_height=?, birth_weight=?, note=?, blood_type=? " +
                "WHERE child_id=?";
        return SQLUtil.executeUpdate(sql,
                child.getMother_id(),
                child.getFather_id(),
                child.getName(),
                child.getAddress(),
                child.getBirth_place(),
                child.getGender(),
                child.getDob(),
                child.getBirth_height(),
                child.getBirth_weight(),
                child.getNote(),
                child.getBlood_type(),
                child.getChild_id()
        );
    }

    public boolean delete(String childId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM child WHERE child_id=?";
        return SQLUtil.executeUpdate(sql, childId);
    }

    public ArrayList<Child> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM child";
        ResultSet resultSet = SQLUtil.executeQuery(sql);
        ArrayList<Child> childList = new ArrayList<>();

        while (resultSet.next()) {
            Child child = new Child(
                    resultSet.getInt("child_id"),
                    resultSet.getString("mother_id"),
                    resultSet.getString("father_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("birth_place"),
                    resultSet.getString("gender"),
                    resultSet.getString("dob"),
                    resultSet.getFloat("birth_height"),
                    resultSet.getFloat("birth_weight"),
                    resultSet.getString("note"),
                    resultSet.getString("blood_type")
            );
            childList.add(child);
        }

        return childList;
    }

}
