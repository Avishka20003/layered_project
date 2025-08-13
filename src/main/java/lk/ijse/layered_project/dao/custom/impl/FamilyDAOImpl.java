package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.FamilyDAO;
import lk.ijse.layered_project.entity.Family;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FamilyDAOImpl implements FamilyDAO {
    @Override
    public ArrayList<Family> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Family> familyList = new ArrayList<>();
        ResultSet result = SQLUtil.executeQuery("select * from family");

        while (result.next()) {
            Family family = new Family(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getString(5),
                    result.getString(6)
            );
            familyList.add(family);
        }
        return familyList;
    }

    @Override
    public boolean save(Family dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Family (mother_id , father_id , midwife_id , contact , reg_date) VALUES (?,?,?,?,?)";
        return SQLUtil.executeUpdate(sql , dto.getMother_id(),dto.getFather_id() ,null, dto.getContact() , dto.getRegDate());
    }

    @Override
    public boolean update(Family dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
