package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.FatherDto;
import lk.ijse.layered_project.entity.Father;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FatherBO extends SuperBO {
    public ArrayList<FatherDto> getAllFather() throws SQLException, ClassNotFoundException ;

    public boolean saveFather(FatherDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateFather(FatherDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteFather(int id) throws SQLException, ClassNotFoundException ;
}
