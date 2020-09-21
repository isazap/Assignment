package nl.isaza.rabo.assignment.api;

import nl.isaza.rabo.assignment.model.DateOfBirth;
import nl.isaza.rabo.assignment.model.Gender;
import nl.isaza.rabo.assignment.model.Name;
import nl.isaza.rabo.assignment.model.User;
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
     * @return the {@link User} of the found user
     */
    public User findUser(String first, String surname) {
        return getUserFromExternalService(first, surname);
    }

    /**
     * Call the external service to get the requested user.
     *
     * @param first   the first name of the user
     * @param surname the surname (last) name of hte user
     * @return the {@link User} of the found user
     */
    private User getUserFromExternalService(String first, String surname) {
        //call client to get matching user - factory pattern?
        //map json response to User ObjectMapper
        //return matching user
        return createTestUser(first, surname);
    }

    /**
     * Placeholder until client available.
     *
     * @param first   the first name of the user
     * @param surname the surname (last) name of hte user
     * @return the {@link User} of the found user
     */
    private User createTestUser(String first, String surname) {
        var name = new Name("Mr", first, surname);
        var dob = new DateOfBirth(LocalDate.of(1980, 2, 12), 40);
        var picture = "https://randomuser.me/api/portraits/med/men/30.jpg";
        return new User(name, Gender.MALE, dob, picture);
    }

}
