package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dto.FamilyDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FamilyBO extends SuperBO {
    public ArrayList<FamilyDto> allFamilyList() throws SQLException, ClassNotFoundException ;

    public boolean saveFamily(FamilyDto family) throws SQLException, ClassNotFoundException ;
}
