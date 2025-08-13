package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dto.MidwifeDto;
import lk.ijse.layered_project.entity.Midwife;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MidwifeBO extends SuperBO {
    public boolean saveMidwife(MidwifeDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateMidwife(MidwifeDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteMidwife(int id) throws SQLException, ClassNotFoundException ;

    public ArrayList<MidwifeDto> getAllMidwife() throws SQLException, ClassNotFoundException ;

}
