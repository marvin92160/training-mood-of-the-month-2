package persistence;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 5432;
    private static final String DB_NAME = "dbmotm";
    private static final String DB_USER = "takima";
    private static final String DB_PASSWORD = "takima";

    private static DataSource dataSource = null;

    private static void init() {
        if (dataSource == null) {
            PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
            pgDataSource.setServerName(DB_HOST);
            pgDataSource.setPortNumber(DB_PORT);
            pgDataSource.setDatabaseName(DB_NAME);
            pgDataSource.setUser(DB_USER);
            pgDataSource.setPassword(DB_PASSWORD);
            dataSource = pgDataSource;
        }
    }

    public static Connection getConnection() throws SQLException {
        init();
        return dataSource.getConnection();
    }
}
