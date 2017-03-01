import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cefothe on 07.12.16.
 */
public class DMLTransactions {
    private static final String URL = "jdbc:mysql://localhost:3306/advancedDB?useSSL=false";
    private static final String USER ="root";
    private static final String PASSWORD = "s73f@n";

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            String   query ="INSERT INTO students (id,name) "+
                            "VALUES (10,'TEST')";
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
