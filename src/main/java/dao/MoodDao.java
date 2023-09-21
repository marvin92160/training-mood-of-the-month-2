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

public class MoodDao {
    public MoodDao(){}
    private static final Logger logger = LoggerFactory.getLogger(MoodDao.class);

    private static final String CREATE_MOOD_QUERY = "INSERT INTO mood(grade, comment, is_public, memberid, date) VALUES(?,?,?,?,?);";
    private static final String DELETE_MOOD_QUERY = "DELETE FROM mood WHERE id=?;";
    private static final String UPDATE_MOOD_QUERY = "UPDATE mood SET grade = ?, comment = ?, is_public = ?, memberid = ?, date = ? WHERE id = ?;";
    private static final String FIND_MOOD_QUERY = "SELECT grade, comment, is_public, memberid, date FROM mood WHERE id=?;";
    private static final String FIND_MOODS_QUERY = "SELECT id, grade, comment, is_public, memberid, date FROM mood;";
    private static final String FIND_MOODS_BY_MONTH = "SELECT * FROM mood WHERE EXTRACT(MONTH FROM date) = ? AND EXTRACT(YEAR FROM date) = ?;";
    private static final String EXTRACT_MONTHS = "SELECT DISTINCT TO_CHAR(date, 'YYYY-MM') AS month_year FROM mood ORDER BY month_year;";
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
            LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
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
            preparedStatement.setTimestamp(5, Timestamp.valueOf(mood.getDate()));
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

    public long delete(long id_member) throws DaoException {
        try(Connection connection = ConnectionManager.getConnection()){
            PreparedStatement ps = connection.prepareStatement(DELETE_MOOD_QUERY);
            ps.setLong(1, id_member);
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

    public long update(Mood mood) throws DaoException {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_MOOD_QUERY);
            ps.setInt(1, mood.getGrade());
            ps.setString(2, mood.getComment());
            ps.setBoolean(3, mood.isPublic());
            ps.setLong(4,mood.getMemberId());
            ps.setTimestamp(5, Timestamp.valueOf(mood.getDate()));
            ps.setLong(6,mood.getId());
            ps.execute();
            ps.close();
            connection.close();
            logger.error("dans le dao"+mood);
            logger.error("dans le dao depuis bdd"+ findById((int)mood.getId()));
        } catch (SQLException e) {
            throw new DaoException();
        }
        return mood.getId();
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
               LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
               moods.add(new Mood(id,grade,comment,is_public,memberid,date));
           }
            return moods;
        }catch (SQLException e) {
            logger.error("An SQL error occurred while executing the query.", e);
            throw new DaoException("An SQL error occurred.", e);
        }
    }

    public List<Mood> findALlByMonth(int month, int year) throws DaoException{
        List<Mood> moods = new ArrayList<Mood>();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_MOODS_BY_MONTH);
            preparedStatement.setInt(1, month);
            preparedStatement.setInt(2, year);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String comment = resultSet.getString("comment");
                int grade = resultSet.getInt("grade");
                boolean is_public = resultSet.getBoolean("is_public");
                int memberid = resultSet.getInt("memberid");
                LocalDateTime date = resultSet.getTimestamp("date").toLocalDateTime();
                moods.add(new Mood(id,grade,comment,is_public,memberid,date));
            }
            return moods;
        }catch (SQLException e) {
            logger.error("An SQL error occurred while executing the query.", e);
            throw new DaoException("An SQL error occurred.", e);
        }
    }

    public List<String> extractMonths() throws DaoException{
        List<String> months = new ArrayList<String>();
        try {
            Connection connection = ConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(EXTRACT_MONTHS);

            while (resultSet.next()){
                String monthYear = resultSet.getString("month_year");
                months.add(monthYear);
            }
            return months;
        }catch (SQLException e) {
            logger.error("An SQL error occurred while executing the query.", e);
            throw new DaoException("An SQL error occurred.", e);
        }
    }
}
