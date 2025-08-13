package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.TestDAO;
import lk.ijse.layered_project.dto.TestDto;
import lk.ijse.layered_project.entity.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDAOImpl implements TestDAO  {


    public boolean save(Test test) throws SQLException, ClassNotFoundException {
        boolean isAdded = SQLUtil.executeUpdate(
                "INSERT INTO test(name, mother_id) VALUES(?,?)",
                test.getName(),
                test.getMother_id()
        );
        return isAdded;
    }

    public ArrayList<Test> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM test");
        ArrayList<Test> tests = new ArrayList<>();
        while (resultSet.next()) {
            Test test = new Test(
                    resultSet.getInt("test_id"),
                    resultSet.getInt("mother_id"),
                    resultSet.getString("test_name")
            );
            tests.add(test);
        }
        return tests;
    }

    public boolean delete(String testId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM test WHERE id=?";
        boolean isDeleted =SQLUtil.executeUpdate(sql, testId);
        return isDeleted;
    }

    public boolean update(Test test) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE test SET name=?, mother_id=? WHERE id=?";
        boolean isUpdated = SQLUtil.executeUpdate(sql, test.getName(), test.getMother_id(), test.getId());
        return isUpdated;
    }
}
