package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.ChildDto;
import lk.ijse.layered_project.entity.Child;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ChildBO extends SuperBO {

    public ArrayList<ChildDto> getAllChild() throws SQLException, ClassNotFoundException ;


    public boolean saveChild(ChildDto dto) throws SQLException, ClassNotFoundException ;


    public boolean updateChild(ChildDto dto) throws SQLException, ClassNotFoundException;

    public boolean deleteChild(String id) throws SQLException, ClassNotFoundException ;
}
