package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.TestDto;
import lk.ijse.layered_project.entity.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TestBO extends SuperBO {
    public ArrayList<TestDto> getAllTest() throws SQLException, ClassNotFoundException ;

    public boolean saveTest(TestDto dto) throws SQLException, ClassNotFoundException ;

    public boolean updateTest(TestDto dto) throws SQLException, ClassNotFoundException ;

    public boolean deleteTest(String id) throws SQLException, ClassNotFoundException ;
}
