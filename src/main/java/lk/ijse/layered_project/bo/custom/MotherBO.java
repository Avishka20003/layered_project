package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.MotherDto;
import lk.ijse.layered_project.entity.Mother;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MotherBO extends SuperBO {
    public ArrayList<MotherDto> getAllMother() throws SQLException, ClassNotFoundException;

    public boolean saveMother(MotherDto dto) throws SQLException, ClassNotFoundException;

    public boolean updateMother(MotherDto dto) throws SQLException, ClassNotFoundException;

    public boolean deleteMother(String id) throws SQLException, ClassNotFoundException;
}