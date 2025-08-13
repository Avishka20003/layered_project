package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.DoctorBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.DoctorDAO;
import lk.ijse.layered_project.dto.DoctorDto;
import lk.ijse.layered_project.entity.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorBOImpl implements DoctorBO {

    DoctorDAO doctorDAO = (DoctorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DOCTOR);

    @Override
    public ArrayList<DoctorDto> getAllDoctor() throws SQLException, ClassNotFoundException {
        ArrayList<Doctor> doctors = doctorDAO.getAll();
        ArrayList<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctor d : doctors) {
            doctorDtos.add(new DoctorDto(
                d.getId(),
                d.getName(),
                d.getAddress(),
                d.getContact(),
                d.getSpecialist(),
                d.getStatus()
            ));
        }
        return doctorDtos;
    }

    @Override
    public boolean saveDoctor(DoctorDto dto) throws SQLException, ClassNotFoundException {
        return doctorDAO.save(new Doctor(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getSpecialist(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean updateDoctor(DoctorDto dto) throws SQLException, ClassNotFoundException {
        return doctorDAO.update(new Doctor(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getContact(),
                dto.getSpecialist(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean deleteDoctor(String id) throws SQLException, ClassNotFoundException {
        return doctorDAO.delete(id);
    }
}
