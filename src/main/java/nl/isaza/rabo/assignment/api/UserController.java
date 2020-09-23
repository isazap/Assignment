package nl.isaza.rabo.assignment.api;

import nl.isaza.rabo.assignment.model.User;
import nl.isaza.rabo.assignment.xapi.XuserApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final XuserApiService xuserApiService;

    public UserController(XuserApiService xuserApiService) {
        this.xuserApiService = xuserApiService;
    }

    @GetMapping
    public UserDto getUser(@RequestParam String first, @RequestParam String surname) {
        User user = xuserApiService.getUser(first, surname);
        return new UserDto(user);
    }

    /*@GetMapping
    public List<NameDto> listUserNames() {
        var userNameList = userService.getUserNames();
        userNameList.stream.
    }*/
}
