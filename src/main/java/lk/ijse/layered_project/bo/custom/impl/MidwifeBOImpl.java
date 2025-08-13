package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.MidwifeBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.MidwifeDAO;
import lk.ijse.layered_project.dao.custom.impl.MidwifeDAOImpl;
import lk.ijse.layered_project.dto.MidwifeDto;
import lk.ijse.layered_project.entity.Midwife;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MidwifeBOImpl implements MidwifeBO {


    MidwifeDAO midwifeDAO = (MidwifeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MIDWIFE);

    @Override
    public boolean saveMidwife(MidwifeDto dto) throws SQLException, ClassNotFoundException {
        return midwifeDAO.save(new Midwife(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    @Override
    public boolean updateMidwife(MidwifeDto dto) throws SQLException, ClassNotFoundException {
        return midwifeDAO.save(new Midwife(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact()
        ));
    }

    @Override
    public boolean deleteMidwife(int id) throws SQLException, ClassNotFoundException {
        return midwifeDAO.delete(id);
    }

    @Override
    public ArrayList<MidwifeDto> getAllMidwife() throws SQLException, ClassNotFoundException {
        ArrayList<Midwife> midwifes = midwifeDAO.getAll();
        ArrayList<MidwifeDto> dtos = new ArrayList<>();
        for (Midwife midwife : midwifes) {
            dtos.add(new MidwifeDto(
                    midwife.getId(),
                    midwife.getName(),
                    midwife.getAddress(),
                    midwife.getContact()
            ));
        }
        return dtos;
    }
}
