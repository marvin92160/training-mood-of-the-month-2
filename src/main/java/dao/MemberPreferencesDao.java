package dao;

import Exception.DaoException;
import modele.MemberPreferences;
import persistence.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberPreferencesDao {

    private static final String INSERT_PREFERENCES_QUERY = "INSERT INTO member_preferences (member_id, mailing_date_option) VALUES (?, ?)";

    public MemberPreferencesDao() {
        // Constructeur par défaut
    }

    public void save(MemberPreferences preferences) throws DaoException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PREFERENCES_QUERY)) {

            preparedStatement.setLong(1, preferences.getMemberId());
            preparedStatement.setInt(2, preferences.getMailingDateOption());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de l'enregistrement des préférences du membre.", e);
        }
    }
}
