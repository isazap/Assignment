package nl.isaza.rabo.assignment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Name name;
    private Gender gender;
    private DateOfBirth dob;
    private String picture;

    public User(Name name, Gender gender, DateOfBirth dob, String picture) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.picture = picture;
    }
}
