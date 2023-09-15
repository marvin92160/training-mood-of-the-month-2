package dao;

import modele.Mood;
import Exception.DaoException;
import persistence.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MoodDao {
    private MoodDao(){}
    private static final Logger logger = LoggerFactory.getLogger(MoodDao.class);

    private static final String CREATE_MOOD_QUERY = "INSERT INTO mood(grade, comment, is_public, memberid, date) VALUES(?,?,?,?,?);";
    private static final String FIND_MOOD_QUERY = "SELECT grade, comment, is_public, memberid, date FROM mood WHERE id=?;";
    private static final String FIND_MOODS_QUERY = "SELECT id, grade, comment, is_public, memberid, date FROM mood;";

    public Mood findById(long id) throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MOOD_QUERY);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String comment = resultSet.getString("comment");
            int grade = resultSet.getInt("grade");
            boolean is_public = resultSet.getBoolean("is_public");
            int memberid = resultSet.getInt("memberid");
            LocalDate date = resultSet.getDate("date").toLocalDate();
            return new Mood(id,grade,comment,is_public,memberid,date);
        }catch (SQLException e) {
            logger.error("An SQL error occurred while executing the query.", e);
            throw new DaoException("An SQL error occurred.", e);
        }
    }

    public long create(Mood mood) throws DaoException{
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MOOD_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, mood.getGrade());
            preparedStatement.setString(2, mood.getComment());
            preparedStatement.setBoolean(3, mood.isPublic());
            preparedStatement.setLong(4,mood.getMemberId());
            preparedStatement.setDate(5, Date.valueOf(mood.getDate()));
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            preparedStatement.close();
            connection.close();
            return id;
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    public List<Mood> findALl() throws DaoException{
        List<Mood> moods = new ArrayList<Mood>();
        try {
            Connection connection = ConnectionManager.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(FIND_MOODS_QUERY);
           while (resultSet.next()){
               int id = resultSet.getInt("id");
               String comment = resultSet.getString("comment");
               int grade = resultSet.getInt("grade");
               boolean is_public = resultSet.getBoolean("is_public");
               int memberid = resultSet.getInt("memberid");
               LocalDate date = resultSet.getDate("date").toLocalDate();
               moods.add(new Mood(id,grade,comment,is_public,memberid,date));
           }
            return moods;
        }catch (SQLException e) {
            logger.error("An SQL error occurred while executing the query.", e);
            throw new DaoException("An SQL error occurred.", e);
        }
    }
}
