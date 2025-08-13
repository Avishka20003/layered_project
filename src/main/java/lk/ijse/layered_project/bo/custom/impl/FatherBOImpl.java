package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.FatherBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.FatherDAO;
import lk.ijse.layered_project.dto.FatherDto;
import lk.ijse.layered_project.entity.Father;

import java.sql.SQLException;
import java.util.ArrayList;

public class FatherBOImpl implements FatherBO {

    FatherDAO fatherDAO = (FatherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FATHER);

    @Override
    public ArrayList<FatherDto> getAllFather() throws SQLException, ClassNotFoundException {
        ArrayList<Father> fathers  = fatherDAO.getAll();
        ArrayList<FatherDto> fatherDtos = new ArrayList<>();
        for (Father father : fathers) {
            fatherDtos.add(new FatherDto(
                    father.getFather_id(),
                    father.getName(),
                    father.getAddress(),
                    father.getNic(),
                    father.getDob(),
                    father.getOccupation(),
                    father.getEmail(),
                    father.getPhone_number(),
                    father.getBlood_type()
            ));
        }
        return fatherDtos;
    }

    @Override
    public boolean saveFather(FatherDto dto) throws SQLException, ClassNotFoundException {
        return fatherDAO.save(new Father(
                dto.getFather_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getNic(),
                dto.getDob(),
                dto.getOccupation(),
                dto.getEmail(),
                dto.getPhone_number(),
                dto.getBlood_type()
        ));
    }

    @Override
    public boolean updateFather(FatherDto dto) throws SQLException, ClassNotFoundException {
        return fatherDAO.update(new Father(
                dto.getFather_id(),
                dto.getName(),
                dto.getAddress(),
                dto.getNic(),
                dto.getDob(),
                dto.getOccupation(),
                dto.getEmail(),
                dto.getPhone_number(),
                dto.getBlood_type()
        ));
    }

    @Override
    public boolean deleteFather(int id) throws SQLException, ClassNotFoundException {
        return fatherDAO.delete(id);
    }
}
