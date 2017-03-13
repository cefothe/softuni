package model.binding;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by cefothe on 05.03.17.
 */
public class CreateUserModel {

    @Size(min = 5, max = 30, message = "The email should be between 5 and 30 symbols")
    private String email;

    @Size(min = 5, message = "The full name should be at least 5 symbols")
    private String fullName;

    @Size(min = 6, message = "The password should be at least 6 symbols")
    @Pattern(regexp = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})$", message = "The password should contain a capital letter, a number and a sign")
    private String password;

    private String repeatPassword;

    public CreateUserModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
