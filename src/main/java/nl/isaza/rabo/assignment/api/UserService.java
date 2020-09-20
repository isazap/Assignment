package nl.isaza.rabo.assignment.api;

import io.netty.util.internal.StringUtil;
import nl.isaza.rabo.assignment.model.Gender;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    public UserService() {
        //Utility class don't instantiate
    }

    /**
     * Finds the user from the external service
     *
     * @param first   the first name of the user
     * @param surname the surname (last) name of hte user
     * @return the {@link UserDto} of the found user
     */
    public UserDto findUser(String first, String surname) {
        //call the Wiremock service to get the user as Json
        //map to a UserDto
        // temp test..
        return getUserFromService(first, surname);
    }

    /**
     * Call the external service to get the requested user.
     *
     * @param first   the first name of the user
     * @param surname the surname (last) name of hte user
     * @return the {@link UserDto} of the found user
     */
    private UserDto getUserFromService(String first, String surname) {
        //WebClient to call service at http://localhost:8000/users
        //query params first and surname
        //map json string to UserDto

        //test for now
        String url = "https://randomuser.me/api/portraits/thumb/men/30.jpg";
        String picture = validURL(url) ? url : StringUtil.EMPTY_STRING;

        return new UserDto(
                first,
                surname,
                Gender.FEMALE,
                LocalDate.of(1980, 2, 13),
                picture);
    }

    /**
     * Checks if a given string is a valid URL
     *
     * @param url the url string to check
     * @return true if it is valid
     */
    private boolean validURL(String url) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return (urlValidator.isValid(url));
    }
}
