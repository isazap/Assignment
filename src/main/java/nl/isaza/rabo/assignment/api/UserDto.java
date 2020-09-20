package nl.isaza.rabo.assignment.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import nl.isaza.rabo.assignment.model.Gender;
import nl.isaza.rabo.assignment.model.User;

import java.util.Date;

public class UserDto {

    @JsonCreator
    public UserDto(
            String first,
            String surname,
            Gender gender,
            Date dob,
            String picture) {
    }

    public UserDto(User user) {
        this(user.getName().getFirst(),
                user.getName().getSurname(),
                user.getGender(),
                user.getDob().getDate(),
                user.getPicture());
    }
}
