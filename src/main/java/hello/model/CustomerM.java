package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ddcnicolasg on 12/3/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerM {

    private String id;

    private String firstName;
    private String lastName;

    public CustomerM(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerM() {
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
