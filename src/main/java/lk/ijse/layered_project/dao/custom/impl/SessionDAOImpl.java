package lk.ijse.layered_project.dao.custom.impl;

import lk.ijse.layered_project.dao.SQLUtil;
import lk.ijse.layered_project.dao.custom.SessionDAO;
import lk.ijse.layered_project.dto.SessionDto;
import lk.ijse.layered_project.entity.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessionDAOImpl implements SessionDAO  {
    public boolean save(Session session) throws SQLException, ClassNotFoundException {
        boolean isAdded = SQLUtil.executeUpdate(
                "INSERT INTO session(topic, description, date, duration, midwife_id) VALUES(?,?,?,?,?)",
                session.getTopic(),
                session.getDescription(),
                session.getDate(),
                session.getDuration(),
                1
        );
        return isAdded;
    }

    public ArrayList<Session> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet =SQLUtil.executeQuery("SELECT * FROM session");
        ArrayList<Session> sessions = new ArrayList<>();
        while (resultSet.next()) {
            Session session = new Session(
                    resultSet.getInt("session_id"),
                    resultSet.getString("topic"),
                    resultSet.getString("description"),
                    resultSet.getString("date"),
                    resultSet.getString("duration"),
                    resultSet.getInt("midwife_id")
            );
            sessions.add(session);
        }
        return sessions;
    }

    public boolean delete(int sessionId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM session WHERE session_id=?";
        boolean isDelete = SQLUtil.executeUpdate(sql,sessionId);
        return isDelete;
    }

    public boolean update(Session session ) throws SQLException, ClassNotFoundException {
        String sql =  "UPDATE session SET topic=?,description=?,date=?,duration=? WHERE session_id=?";
        boolean isUpdated = SQLUtil.executeUpdate(sql ,session.getTopic(),session.getDescription(),session.getDate(),session.getDuration(),session.getSession_id());
        return isUpdated;
    }
}
