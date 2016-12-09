package app.terminal;

import app.domain.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by cefothe on 10.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUserName("gosho");
        user.setEmail("gosho@abv.bg");
        user.setPassword("Aa#242dsa34");
        user.setRegisteredOn(new Date());
        user.setLastTimeLoggedIn(new Date());
        user.setDeleted(false);
        user.setAge(22);
    }
}
