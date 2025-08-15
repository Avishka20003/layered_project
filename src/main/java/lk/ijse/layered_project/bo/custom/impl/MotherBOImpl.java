package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.FatherBO;
import lk.ijse.layered_project.bo.custom.MotherBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.FamilyDAO;
import lk.ijse.layered_project.dao.custom.FatherDAO;
import lk.ijse.layered_project.dao.custom.MotherDAO;
import lk.ijse.layered_project.db.DBConnection;
import lk.ijse.layered_project.dto.MotherDto;
import lk.ijse.layered_project.entity.Family;
import lk.ijse.layered_project.entity.Mother;
import lk.ijse.layered_project.view.MotherTm;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MotherBOImpl implements MotherBO {

    MotherDAO motherDAO = (MotherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MOTHER);
    FamilyDAO familyDAO = (FamilyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FAMILY);
    @Override
    public ArrayList<MotherDto> getAllMother() throws SQLException, ClassNotFoundException {
        ArrayList<Mother> mothers = motherDAO.getAll();
        ArrayList<MotherDto> motherDtos = new ArrayList<>();
        for (Mother mother : mothers) {
            motherDtos.add(new MotherDto(
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
                    mother.getBlood_type(),
                    mother.getFather_id()
            ));
        }
        return motherDtos;
    }

    @Override
    public boolean saveMother(MotherDto dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try{
            int nextId = motherDAO.getNextId();

            boolean isSaveMother = motherDAO.save(new Mother(
                    nextId,
                    dto.getName(),
                    dto.getAddress(),
                    dto.getNic(),
                    dto.getDob(),
                    dto.getOccupation(),
                    dto.getEmail(),
                    dto.getPhone_number(),
                    dto.getWeight(),
                    dto.getHeight(),
                    dto.getAllergies(),
                    dto.getMedical_history(),
                    dto.getNote(),
                    dto.getBlood_type(),
                    dto.getFather_id()
            ));

            if (!isSaveMother) {
                throw new RuntimeException("Failed to add mother record");
            }

            Date today = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(today);

            boolean isAddFamily = familyDAO.save(new Family(nextId,dto.getFather_id(),0,dto.getPhone_number(),formattedDate));

            if (!isAddFamily) {
                throw new RuntimeException("Failed to add family record");
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean updateMother(MotherDto dto) throws SQLException, ClassNotFoundException {
        return motherDAO.update(new Mother(
                dto.getMother_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getNic(),
                dto.getDob(),
                dto.getOccupation(),
                dto.getEmail(),
                dto.getPhone_number(),
                dto.getWeight(),
                dto.getHeight(),
                dto.getAllergies(),
                dto.getMedical_history(),
                dto.getNote(),
                dto.getBlood_type(),
                dto.getFather_id()
        ));
    }

    @Override
    public boolean deleteMother(int id) throws SQLException, ClassNotFoundException {
        return motherDAO.delete(id);
    }
}
