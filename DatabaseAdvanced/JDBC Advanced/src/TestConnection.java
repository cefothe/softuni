import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
    private static final String USER ="root";
    private static final String PASSWORD = "s73f@n";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Susscess connections");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
