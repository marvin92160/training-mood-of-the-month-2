package dao;

import Exception.DaoException;
import modele.MemberPreferences;
import persistence.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberPreferencesDao {

    private static final String INSERT_PREFERENCES_QUERY = "INSERT INTO member_preferences (member_id, mailing_date_option, mailing_time_option) VALUES (?, ?, ?)";
    private static final String SELECT_MEMBERS_TO_CONTACT_QUERY = "SELECT mp.member_id FROM member_preferences mp WHERE mp.mailing_date_option = ? AND mp.mailing_time_option = ?;";

    public MemberPreferencesDao() {
        // Constructeur par défaut
    }

    public void save(MemberPreferences preferences) throws DaoException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PREFERENCES_QUERY)) {

            preparedStatement.setLong(1, preferences.getMemberId());
            preparedStatement.setInt(2, preferences.getMailingDateOption());
            preparedStatement.setTime(3, preferences.getMailingTimeOption());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de l'enregistrement des préférences du membre.", e);
        }
    }

    public List<Long> getMembersToContact(int mailingDateOption) throws DaoException {
        List<Long> memberIds = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBERS_TO_CONTACT_QUERY)) {

            preparedStatement.setInt(1, mailingDateOption);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long memberId = resultSet.getLong("member_id");
                memberIds.add(memberId);
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la récupération des membres à contacter.", e);
        }
        return memberIds;
    }
}
