package session;

import java.io.Serializable;

/**
 * Created by cefothe on 02.03.17.
 */
public class User  implements Serializable{

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
