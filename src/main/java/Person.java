import java.io.Serializable;

public class Person implements Serializable {
    private String firstName = null;
    private String lastName = null;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
