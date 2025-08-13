package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.EmployeeBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.CashierDAO;
import lk.ijse.layered_project.dao.custom.EmployeeDAO;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);


    @Override
    public boolean addEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(
                dto.getEmployeeId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getAddress(),
                dto.getRole(),
                dto.getSpecialist(),
                dto.getStatus(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(
                dto.getEmployeeId(),
                dto.getName(),
                dto.getContactNumber(),
                dto.getAddress(),
                dto.getRole(),
                dto.getSpecialist(),
                dto.getStatus(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
