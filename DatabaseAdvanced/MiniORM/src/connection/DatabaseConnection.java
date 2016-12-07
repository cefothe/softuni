package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cefothe on 07.12.16.
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/advancedDB?useSSL=false";
    private static final String USER ="root";
    private static final String PASSWORD = "s73f@n";

    public static Connection  getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
