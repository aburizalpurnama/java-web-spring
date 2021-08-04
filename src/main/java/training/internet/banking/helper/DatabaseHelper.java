package training.internet.banking.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    static Connection connection;
    public static Connection connect(){
        try {
            connection = DriverManager.getConnection(Config.JDBC_URL, Config.JDBC_USERNAME,
                    Config.JDBC_PASSWORD);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return connection;
    }
}
