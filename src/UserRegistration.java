import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration {
    private Connection connection;

    public UserRegistration(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUser(String username, String password, boolean isAdmin, String email) {
        String sql = "INSERT INTO users (username, password, is_admin, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setBoolean(3, isAdmin);
            pst.setString(4, email);

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public User loginUser(String username, String password) {
        String sql = "SELECT is_admin FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    boolean isAdmin = rs.getBoolean("is_admin");
                    return new User(username, isAdmin);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
