package dao;

import modele.Member;
import Exception.DaoException;
import persistence.ConnectionManager;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MemberDao {

    public MemberDao(){}

    private static final String CREATE_MEMBER_QUERY = "INSERT INTO member(firstname, lastname, email, birthdate) VALUES(?, ?, ?, ?);";
    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    public long create(Member membre) throws DaoException{
       try (Connection connection = ConnectionManager.getConnection()){

           PreparedStatement ps = connection.prepareStatement(CREATE_MEMBER_QUERY, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, membre.getFirstName());
           ps.setString(2, membre.getLastName());
           ps.setString(3, membre.getEmail());
           ps.setDate(4, Date.valueOf(membre.getBirthdate()));
           ps.execute();
           ResultSet resultSet = ps.getGeneratedKeys();
           int id=0;
           if(resultSet.next()){
               id = resultSet.getInt(1);
           }
           return id;

        } catch (SQLException e) {
           throw new DaoException();
        }
    }

}            /*Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_MEMBER_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, membre.getLastName());
            ps.setString(2, membre.getFirstName());
            ps.setString(3, membre.getEmail());
            ps.setDate(4, Date.valueOf(membre.getBirthdate()));
            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();

            ps.close();
            connection.close();*/



