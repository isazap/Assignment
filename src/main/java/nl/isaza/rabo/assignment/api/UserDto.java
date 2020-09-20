package nl.isaza.rabo.assignment.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import nl.isaza.rabo.assignment.model.Gender;
import nl.isaza.rabo.assignment.model.User;

import java.net.URL;
import java.util.Date;

public class UserDto {
    private String first;
    private String surname;
    private Gender gender;
    private Date dob;
    private URL picture;

    @JsonCreator
    public UserDto (
            String first,
            String surname,
            Gender gender,
            Date dob,
            URL picture ) {
        this.first = first;
        this.surname = surname;
        this.gender = gender;
        this.dob = dob;
        this.picture = picture;
    }

    public UserDto(User user) {
        this(user.getName().getFirst(),
        user.getName().getSurname(),
        user.getGender(),
        user.getDob().getDate(),
        user.getPicture());
    }
}
