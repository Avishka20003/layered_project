package lk.ijse.layered_project.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.FamilyDAO;
import lk.ijse.layered_project.dao.custom.MotherDAO;
import lk.ijse.layered_project.db.DBConnection;
import lk.ijse.layered_project.dto.FamilyDto;
import lk.ijse.layered_project.dto.MotherDto;
import lk.ijse.layered_project.entity.Mother;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MotherDAOImpl implements MotherDAO {

//    FamilyModel familyModel = new FamilyModel();


    public boolean save(Mother mother) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{

            int nextId = getMotherNextId();

            String sql = "INSERT INTO mother (mother_id,name, address, nic, dob, occupation, email, phone_number, weight, height, allergies, medical_history, note, blood_type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            boolean isSaveMother =  SQLUtil.executeUpdate(sql,
                    nextId,
                    mother.getName(),
                    mother.getAddress(),
                    mother.getNic(),
                    mother.getDob(),
                    mother.getOccupation(),
                    mother.getEmail(),
                    mother.getPhone_number(),
                    mother.getWeight(),
                    mother.getHeight(),
                    mother.getAllergies(),
                    mother.getMedical_history(),
                    mother.getNote(),
                    mother.getBlood_type()
            );

            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(today);

            boolean isAdded = familyModel.addFamily(new FamilyDto(nextId , mother.getFather_id(),0,mother.getPhone_number(),formattedDate));

            if(isAdded && isSaveMother) {
                connection.commit();
                return true;
            }
            connection.rollback();
            return false;

        } catch (Exception e) {
            connection.rollback();
            new Alert(Alert.AlertType.ERROR,"Error : " + e.getMessage()).show();
            throw new SQLException(e.getMessage());
        } finally {
            connection.setAutoCommit(true);
        }*/
        String sql = "INSERT INTO mother (mother_id,name, address, nic, dob, occupation, email, phone_number, weight, height, allergies, medical_history, note, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        boolean isSaveMother =  SQLUtil.executeUpdate(sql,
                mother.getMother_id(),
                mother.getName(),
                mother.getAddress(),
                mother.getNic(),
                mother.getDob(),
                mother.getOccupation(),
                mother.getEmail(),
                mother.getPhone_number(),
                mother.getWeight(),
                mother.getHeight(),
                mother.getAllergies(),
                mother.getMedical_history(),
                mother.getNote(),
                mother.getBlood_type()
        );
        return isSaveMother;
    }

    public int getNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.executeQuery("SELECT MAX(mother_id) FROM Mother ORDER BY mother_id LIMIT 1");

        if (resultSet.next()){
            return resultSet.getInt(1)+1;
        }
        return 0;
    }



    public boolean update(Mother mother) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE mother SET name=?, address=?, nic=?, dob=?, occupation=?, email=?, phone_number=?, weight=?, height=?, allergies=?, medical_history=?, note=?, blood_type=? " +
                "WHERE mother_id=?";
        return SQLUtil.executeUpdate(sql,
                mother.getName(),
                mother.getAddress(),
                mother.getNic(),
                mother.getDob(),
                mother.getOccupation(),
                mother.getEmail(),
                mother.getPhone_number(),
                mother.getWeight(),
                mother.getHeight(),
                mother.getAllergies(),
                mother.getMedical_history(),
                mother.getNote(),
                mother.getBlood_type(),
                mother.getMother_id()
        );
    }

    public boolean delete(int motherId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM mother WHERE mother_id=?";
        return SQLUtil.executeUpdate(sql, motherId);
    }

    public ArrayList<Mother> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM mother";
        ResultSet resultSet =SQLUtil.executeQuery(sql);
        ArrayList<Mother> motherList = new ArrayList<>();

        while (resultSet.next()) {
            Mother mother = new Mother(
                    resultSet.getInt("mother_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("dob"),
                    resultSet.getString("occupation"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("weight"),
                    resultSet.getInt("height"),
                    resultSet.getString("allergies"),
                    resultSet.getString("medical_history"),
                    resultSet.getString("note"),
                    resultSet.getString("blood_type")
            );
            motherList.add(mother);
        }

        return motherList;
    }

   /* public ArrayList<Test> getAllTestMotherById(int id) throws SQLException, ClassNotFoundException {
        ArrayList<Test> ids = new ArrayList<>();
        String sql = "SELECT * FROM Test where mother_id=?";
        ResultSet resultSet = SQLUtil.executeQuery(sql);
        while (resultSet.next()) {
            Test test = new Test(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
            );
        }
        return ids;
    }
*/


    public int getMotherNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT MAX(mother_id) FROM Mother ORDER BY mother_id LIMIT 1");

        if (resultSet.next()){
            return resultSet.getInt(1)+1;
        }
        return 0;
    }


}
