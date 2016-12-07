import java.sql.*;

/**
 * Created by cefothe on 07.12.16.
 */
public class JDBCPreparedStatement {

    private static final String URL = "jdbc:mysql://localhost:3306/advancedDB?useSSL=false";
    private static final String USER ="root";
    private static final String PASSWORD = "s73f@n";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
