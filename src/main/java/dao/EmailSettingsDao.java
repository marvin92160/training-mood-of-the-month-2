package dao;

public class EmailSettingsDao {
    public EmailSettingsDao() {}

    private static final String CREATE_MAIL_SETTINGS_QUERY = "INSERT INTO settings(id, frequency, time) VALUES(1, 1, 02:50:21);";
    private static final String UPDATE_MAIL_SETTINGS_QUERY = "UPDATE settings SET frequency = ?, time = ? WHERE id = 1;";

}