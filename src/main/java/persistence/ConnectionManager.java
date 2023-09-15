package persistence;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 5432;
    private static final String DB_NAME = "dbmotm";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "test";

    private static DataSource dataSource = null;

    private static void init() {
        if (dataSource == null) {
            PGSimpleDataSource pgDataSource = new PGSimpleDataSource();
            pgDataSource.setServerNames(new String[]{DB_HOST});
            pgDataSource.setPortNumbers(new int[]{DB_PORT});
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
