package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.SuperDAO;
import lk.ijse.layered_project.dto.EmployeeDto;
import lk.ijse.layered_project.entity.Employee;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    public boolean addEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException ;

}
