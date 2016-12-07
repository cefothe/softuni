import connection.DatabaseConnection;
import models.User;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            EntityManager em = new EntityManager(DatabaseConnection.getConnection());
            User user = new User("Ivan",23, new Date());
            user.setId(1);
            em.persist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
