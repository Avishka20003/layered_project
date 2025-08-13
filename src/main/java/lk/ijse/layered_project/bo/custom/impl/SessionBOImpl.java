package lk.ijse.layered_project.bo.custom.impl;

import lk.ijse.layered_project.bo.custom.SessionBO;
import lk.ijse.layered_project.dao.DAOFactory;
import lk.ijse.layered_project.dao.custom.SessionDAO;
import lk.ijse.layered_project.dto.SessionDto;
import lk.ijse.layered_project.entity.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public class SessionBOImpl implements SessionBO {

    SessionDAO sessionDAO = (SessionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SESSION);

    @Override
    public ArrayList<SessionDto> getAllSession() throws SQLException, ClassNotFoundException {
        ArrayList<Session> sessions = sessionDAO.getAll();
        ArrayList<SessionDto> sessionDtos = new ArrayList<>();
        for (Session session : sessions) {
            sessionDtos.add(new SessionDto(
                    session.getSession_id(),
                    session.getTopic(),
                    session.getDescription(),
                    session.getDate(),
                    session.getDuration(),
                    session.getMidwife_id()
            ));
        }
        return sessionDtos;
    }


    @Override
    public boolean saveSession(SessionDto dto) throws SQLException, ClassNotFoundException {
        return sessionDAO.save(new Session(
                dto.getSession_id(),
                dto.getTopic(),
                dto.getDescription(),
                dto.getDate(),
                dto.getDuration(),
                dto.getMidwife_id()
        ));
    }

    @Override
    public boolean updateSession(SessionDto dto) throws SQLException, ClassNotFoundException {
        return sessionDAO.update(new Session(
                dto.getSession_id(),
                dto.getTopic(),
                dto.getDescription(),
                dto.getDate(),
                dto.getDuration(),
                dto.getMidwife_id()
        ));
    }

    @Override
    public boolean deleteSession(int id) throws SQLException, ClassNotFoundException {
        return sessionDAO.delete(id);

}
}
