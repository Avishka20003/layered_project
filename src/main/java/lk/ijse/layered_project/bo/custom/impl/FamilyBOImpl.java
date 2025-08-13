package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.FamilyBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.FamilyDAO;
import lk.ijse.layered_project.dto.FamilyDto;
import lk.ijse.layered_project.entity.Family;

import java.sql.SQLException;
import java.util.ArrayList;

public class FamilyBOImpl implements FamilyBO {

    FamilyDAO familyDAO = (FamilyDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.FAMILY);
    @Override
    public ArrayList<FamilyDto> allFamilyList() throws SQLException, ClassNotFoundException {
       ArrayList<Family> families = familyDAO.getAll();
       ArrayList<FamilyDto> familyDtos = new ArrayList<>();
       for (Family family : families) {
           familyDtos.add(new FamilyDto(
                   family.getFamily_id(),
                   family.getMother_id(),
                   family.getFamily_id(),
                   family.getMidwife_if(),
                   family.getContact(),
                   family.getRegDate()
           ));
       }
       return familyDtos;
    }

    @Override
    public boolean saveFamily(FamilyDto family) throws SQLException, ClassNotFoundException {
        return familyDAO.save(new Family(
                family.getFamily_id(),
                family.getMother_id(),
                family.getFamily_id(),
                family.getMidwife_if(),
                family.getContact(),
                family.getRegDate()
        ));
    }
}
