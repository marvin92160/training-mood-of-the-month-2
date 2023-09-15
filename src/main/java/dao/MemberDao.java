package dao;

import modele.Member;
import Exception.DaoException;
import modele.Mood;
import persistence.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MemberDao {

    public MemberDao(){}

    private static final String CREATE_MEMBER_QUERY = "INSERT INTO member(firstname, lastname, email, birthdate) VALUES(?, ?, ?, ?);";
    private static final String UPDATE_MEMBER_QUERY = "UPDATE member SET firstname = ?, lastname = ?, email = ?, birthdate = ? WHERE id = ?;";
    private static final String DELETE_MEMBER_QUERY = "DELETE FROM member WHERE id=?;";
    private static final String FIND_MEMBER_QUERY = "SELECT firstname, lastname, email, birthdate FROM member WHERE id=?;";
    private static final String FIND_MEMBERS_QUERY = "SELECT id, firstname, lastname, email, birthdate FROM member;";
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
    public long delete(int Id_member) throws DaoException {
        try(Connection connection = ConnectionManager.getConnection()){
            PreparedStatement ps = connection.prepareStatement(DELETE_MEMBER_QUERY);
            ps.setInt(1, Id_member);
            if(ps.executeUpdate()!=0){
                return 1;
            }
            else{
                return 0;
            }
        }
        catch(SQLException e){
            throw new DaoException();
        }
    }

    public Member findById(int id) throws DaoException {
        try {
            String lastName ="";
            String firstName = "";
            String email = "";
            LocalDate birthdate  = LocalDate.now();
            Connection connexion = ConnectionManager.getConnection();
            PreparedStatement ps = connexion.prepareStatement(FIND_MEMBER_QUERY);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                lastName= resultSet.getString("lastname");
                firstName = resultSet.getString("firstname");
                email = resultSet.getString("email");
                birthdate = resultSet.getDate("birthdate").toLocalDate();
            }
            return new Member(id, lastName, firstName, email, birthdate);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        }
    }

    public long update(Member member) throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_MEMBER_QUERY);
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getEmail());
            ps.setDate(4, Date.valueOf(member.getBirthdate()));
            ps.setLong(5, member.getId());
            ps.execute();
            ps.close();
            connection.close();
            logger.error("dans le dao"+member);
            logger.error("dans le dao depuis bdd"+ findById((int)member.getId()));
        } catch (SQLException e) {
            throw new DaoException();
        }
        return member.getId();
    }

    public List<Member> findAll() throws DaoException {
        List<Member> members = new ArrayList<Member>();
        try {
            LocalDate birthdate = LocalDate.now();
            Connection connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(FIND_MEMBERS_QUERY);
            while(rs.next()){
                int id = rs.getInt("id");
                String lastName = rs.getString("lastname");
                String firstName= rs.getString("firstname");
                String email = rs.getString("email");
                birthdate = rs.getDate("birthdate").toLocalDate();

                members.add( new Member( id,lastName,firstName,email,birthdate ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return members;

    }



}


