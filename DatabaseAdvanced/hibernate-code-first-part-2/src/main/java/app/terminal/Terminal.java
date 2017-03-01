package app.terminal;

import app.domain.User;
import app.services.UserService;
import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        user.setAge(16);

        Path path = Paths.get("res/smallpic.jpg");
        byte[] data = Files.readAllBytes(path);

        user.setProfilePicture(data);

        userService.createUser(user);

        userService.findUserByEmail("gosho@abv.bg").stream().forEach(x -> {System.out.println(x.getUserName());});

        System.out.println(userService.countOfBigPictures(100));
    }
}
