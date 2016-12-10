package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

    @Column(name= "registered_on")
    private Date registeredOn;

    @Column(name = "last_time_logged_in")
    private Date lastTimeLoggedIn;

    @Basic
    private Integer age;

    @Column(name ="is_deleted")
    private Boolean isDeleted;

    public User() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.length() >4 && userName.length()<30)
        {
            this.userName = userName;}
        else {
            throw  new IllegalArgumentException();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(!this.validatePattern(password,PASSWORD_PATTERN)){
            throw  new IllegalArgumentException();
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!this.validatePattern(email, EMAIL_PATTERN)){
            throw  new IllegalArgumentException();
        }
        this.email = email;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if(profilePicture.length> 1024*1024){
            throw  new IllegalArgumentException();
        }
        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age<1 || age>20){
            throw  new IllegalArgumentException();
        }
        this.age = age;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    private boolean validatePattern(String item, String pattern){
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(item);
            if(matcher.find()){
                return true;
            }
        return false;
    }
}
