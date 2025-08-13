package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dto.DoctorDto;
import lk.ijse.layered_project.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DoctorBO extends SuperBO {
    public ArrayList<DoctorDto> getAllDoctor() throws SQLException, ClassNotFoundException ;

    public boolean saveDoctor(DoctorDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateDoctor(DoctorDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteDoctor(String id) throws SQLException, ClassNotFoundException ;
}
