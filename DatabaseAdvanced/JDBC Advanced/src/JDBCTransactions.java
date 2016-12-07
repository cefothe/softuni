import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cefothe on 07.12.16.
 */
public class JDBCTransactions {

    private static final String URL = "jdbc:mysql://localhost:3306/advancedDB?useSSL=false";
    private static final String USER ="root";
    private static final String PASSWORD = "s73f@n";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String query ="INSERT INTO students (id,name) "+
                    "VALUES (15,'TEST')";
            statement.execute(query);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
