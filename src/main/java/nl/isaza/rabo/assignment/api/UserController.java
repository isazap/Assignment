package nl.isaza.rabo.assignment.api;

import nl.isaza.rabo.assignment.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserDto getUser(@RequestParam String first, @RequestParam String surname) {
        User user = userService.findUser(first, surname);
        return new UserDto(user);
    }
}
