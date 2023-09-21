package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.ConnectionManager;

public class FillDatabase {


    public static void main(String[] args) throws Exception {
        try {
            insertWithPreparedStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement createPreparedStatement = null;

        List<String> createTablesQueries = new ArrayList<>();
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS member (\n" +
                "                        id SERIAL PRIMARY KEY,\n" +
                "                        firstname VARCHAR(255) NOT NULL,\n" +
                "                        lastname VARCHAR(255) NOT NULL,\n" +
                "                        email VARCHAR(255) NOT NULL,\n" +
                "                        birthdate DATE\n" +
                ");");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS mood (\n" +
                "                      id SERIAL PRIMARY KEY,\n" +
                "                      grade INTEGER NOT NULL,\n" +
                "                      comment TEXT,\n" +
                "                      is_public BOOLEAN NOT NULL,\n" +
                "                      memberId INTEGER REFERENCES member(id),\n" +
                "                      date TIMESTAMP NOT NULL\n" +
                ");");

        try {
            connection.setAutoCommit(true);

            for (String createQuery : createTablesQueries) {
                createPreparedStatement = connection.prepareStatement(createQuery);
                createPreparedStatement.executeUpdate();
                createPreparedStatement.close();
            }

            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO member(firstname, lastname, email, birthdate) VALUES('Loic', 'Ortola', 'lortola@e-biz.fr', '1988-02-10');");
            stmt.execute("INSERT INTO member(firstname, lastname, email, birthdate) VALUES('Antoine', 'Lebel', 'alebel@e-biz.fr', '1991-07-11');");
            stmt.execute("INSERT INTO member(firstname, lastname, email, birthdate) VALUES('Romain', 'Larroque', 'rlarroque@e-biz.fr', '1992-03-18');");
            stmt.execute("INSERT INTO member(firstname, lastname, email, birthdate) VALUES('Hubert B.', 'Delabatte', 'hdelabatte@e-biz.fr', '1916-02-10');");
            //connection.commit();

            stmt.execute("INSERT INTO mood(grade, comment, is_public, memberId, date) VALUES(1, 'Jaime pas', true, 4, '2023-09-03 08:30:00');");
            stmt.execute("INSERT INTO mood(grade, comment, is_public, memberId, date) VALUES(3, null, true, 3, '2023-09-10 08:30:00');");
            stmt.execute("INSERT INTO mood(grade, comment, is_public, memberId, date) VALUES(5, null, true, 1, '2023-09-22 08:30:00');");
            stmt.execute("INSERT INTO mood(grade, comment, is_public, memberId, date) VALUES(5, 'Cest cool', false, 2, '2023-09-22 08:30:00');");

            //connection.commit();
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}