package dao;

import modele.Member;
import Exception.DaoException;
import persistence.ConnectionManager;

import java.sql.*;

public class MembreDao {

    public MembreDao(){}

    private static final String CREATE_MEMBER_QUERY = "INSERT INTO member(firstname, lastname, email, birthdate) VALUES(?, ?, ?, ?);";

    public long create(Member membre) throws DaoException{
        long id = 0;
       try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_MEMBER_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, membre.getFirstName());
            ps.setString(2, membre.getLastName());
            ps.setString(3, membre.getEmail());
            ps.setDate(4, Date.valueOf(membre.getBirthdate()));
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return id;
    }

}


