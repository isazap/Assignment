package nl.isaza.rabo.assignment.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import nl.isaza.rabo.assignment.model.Gender;
import nl.isaza.rabo.assignment.model.User;

import java.time.LocalDate;

@Getter
public class UserDto {
    private final String first;
    private final String surname;
    private final Gender gender;
    private final LocalDate dob;
    private final String picture;

    @JsonCreator
    public UserDto(
            String first,
            String surname,
            Gender gender,
            LocalDate dob,
            String picture) {
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
