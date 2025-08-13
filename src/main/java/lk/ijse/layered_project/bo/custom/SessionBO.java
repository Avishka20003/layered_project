package lk.ijse.layered_project.bo.custom;

import lk.ijse.layered_project.bo.SuperBO;
import lk.ijse.layered_project.dao.CrudDAO;
import lk.ijse.layered_project.dto.SessionDto;
import lk.ijse.layered_project.entity.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SessionBO extends SuperBO {
    public ArrayList<SessionDto> getAllSession() throws SQLException, ClassNotFoundException;

    public boolean saveSession(SessionDto dto) throws SQLException, ClassNotFoundException;

    public boolean updateSession(SessionDto dto) throws SQLException, ClassNotFoundException;

    public boolean deleteSession(String id) throws SQLException, ClassNotFoundException;
}