package dao;

import modele.Member;
import modele.Mood;
import Exception.DaoException;
import persistence.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotmDao {
    public MotmDao(){}
    private static final Logger logger = LoggerFactory.getLogger(MoodDao.class);

    private static final String UPDATE_MOTM_QUERY = "UPDATE motm SET template = ? WHERE id = 1;";

    private static final String FIND_MOTM_QUERY = "SELECT template FROM motm WHERE id = ?;";
    public String find() throws DaoException {
        try {
            String template = "";
            Connection connexion = ConnectionManager.getConnection();
            PreparedStatement ps = connexion.prepareStatement(FIND_MOTM_QUERY);
            ps.setLong(1, 1);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                template = resultSet.getString("template");
            }
            return template;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        }
    }

    public void update(String template) throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_MOTM_QUERY);
            ps.setString(1, template);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

}
