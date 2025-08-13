package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.ClinicDto;
import lk.ijse.layered_project.entity.Clinic;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClinicBO extends SuperBO {

    public ArrayList<ClinicDto> getAllClinic() throws SQLException, ClassNotFoundException ;
    public boolean saveClinic(ClinicDto dto) throws SQLException, ClassNotFoundException ;
    public boolean updateClinic(ClinicDto dto) throws SQLException, ClassNotFoundException ;
    public boolean deleteClinic(String id) throws SQLException, ClassNotFoundException ;
}
