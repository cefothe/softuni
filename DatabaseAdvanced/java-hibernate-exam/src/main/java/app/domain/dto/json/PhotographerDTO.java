package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by cefothe on 11.12.16.
 */
public class PhotographerDTO implements Serializable {

    @Expose
    public String firstName;
    @Expose
    public String lastName;
    @Expose
    public String phone;
    @Expose
    public Set<Long> lenses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Long> getLenses() {
        return lenses;
    }

    public void setLenses(Set<Long> lenses) {
        this.lenses = lenses;
    }
}
