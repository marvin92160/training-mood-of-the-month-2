package Exception;

import java.sql.SQLException;

public class DaoException extends Exception{
    public DaoException(String s, SQLException e) {

    }

    public DaoException() {

    }
}
