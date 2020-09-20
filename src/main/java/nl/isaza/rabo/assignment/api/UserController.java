package nl.isaza.rabo.assignment.api;

import nl.isaza.rabo.assignment.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public UserDto getUser(@PathVariable String first, @PathVariable String surname) {
        //service to get the user with this first name and surname
        return new UserDto();
    }
}
