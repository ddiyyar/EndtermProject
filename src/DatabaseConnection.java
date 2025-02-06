import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public static DatabaseConnection getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection(url, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
