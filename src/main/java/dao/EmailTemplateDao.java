package dao;

import Exception.DaoException;
import modele.Member;
import persistence.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmailTemplateDao {
    public EmailTemplateDao(){}
    private static final Logger logger = LoggerFactory.getLogger(MoodDao.class);

    private static final String UPDATE_MAIL_QUERY = "UPDATE email SET subject = ?, template = ? WHERE id = 1;";
    private static final String FIND_MAIL_QUERY = "SELECT subject, template FROM email WHERE id = ?;";
    public List<String> find() throws DaoException {
        try {
            List<String> template = new ArrayList<>();
            Connection connexion = ConnectionManager.getConnection();
            PreparedStatement ps = connexion.prepareStatement(FIND_MAIL_QUERY);
            ps.setLong(1, 1);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                template.add(resultSet.getString("subject"));
                logger.error(template.get(0));
                template.add(resultSet.getString("template"));
            }
            return template;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        }
    }

    public void update(String subject, String template) throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_MAIL_QUERY);
            ps.setString(1, subject);
            ps.setString(2, template);
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

}
