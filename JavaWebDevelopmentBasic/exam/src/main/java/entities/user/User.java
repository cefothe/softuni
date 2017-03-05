package entities.user;

import entities.common.BaseEntityAdapter;
import entities.game.Game;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static entities.user.User.FIND_BY_USERNAME_AND_PASSWORD;
import static entities.user.User.NUMBER_OF_USER;

/**
 * Created by cefothe on 05.03.17.
 */

@NamedQueries({
        @NamedQuery(name = FIND_BY_USERNAME_AND_PASSWORD, query = "SELECT u from User as u WHERE u.email=:email and u.password=:password"),
        @NamedQuery(name= NUMBER_OF_USER, query = "SELECT count(u.id) from User u")
})
@Entity
@Table(name = "users")
public class User extends BaseEntityAdapter implements Serializable{

    public static final String FIND_BY_USERNAME_AND_PASSWORD = "findByUsernameAndPassword";
    public  static final String NUMBER_OF_USER = "numberOfUser";

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Game> games;

    public User(String email, String password,String fullName, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullName= fullName;
        this.games = new ArrayList<>();
    }

    protected User(){

    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public List<Game> getGames() {
        return games;
    }

    public void addGame(Game game){
       if(game==null){
           return;
       }
        games.add(game);
    }
    public void addGames(List<Game> games){
        if(games== null){
            return;
        }
        this.games.addAll(games);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
