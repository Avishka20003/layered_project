package lk.ijse.layered_project.bo.custom.impl;


import lk.ijse.layered_project.bo.custom.ClinicBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.ClinicDAO;
import lk.ijse.layered_project.dto.ClinicDto;
import lk.ijse.layered_project.entity.Clinic;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicBOImpl implements ClinicBO {

    ClinicDAO clinicDAO = (ClinicDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLINIC);

    @Override
    public ArrayList<ClinicDto> getAllClinic() throws SQLException, ClassNotFoundException {
        ArrayList<Clinic> clinics = clinicDAO.getAll();
        ArrayList<ClinicDto> clinicDtos = new ArrayList<>();
        for (Clinic clinic : clinics) {
            clinicDtos.add(new ClinicDto(
                   clinic.getClinic_id(),
                    clinic.getClinic_name(),
                    clinic.getClinic_location(),
                    clinic.getDescription(),
                    clinic.getContact(),
                    clinic.getStatus()
            ));
        }
        return clinicDtos;
    }

    @Override
    public boolean saveClinic(ClinicDto dto) throws SQLException, ClassNotFoundException {
        return clinicDAO.save(new Clinic(
                dto.getClinic_id(),
                dto.getClinic_name(),
                dto.getClinic_location(),
                dto.getDescription(),
                dto.getContact(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean updateClinic(ClinicDto dto) throws SQLException, ClassNotFoundException {
        return clinicDAO.update(new Clinic(
                dto.getClinic_id(),
                dto.getClinic_name(),
                dto.getClinic_location(),
                dto.getDescription(),
                dto.getContact(),
                dto.getStatus()
        ));
    }

    @Override
    public boolean deleteClinic(String id) throws SQLException, ClassNotFoundException {
        return clinicDAO.delete(id);
    }
}
