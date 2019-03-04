package nhfzaki.usermanagement.controller;

import nhfzaki.usermanagement.model.User;
import nhfzaki.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nhf-zaki on 3/3/19
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public List<User> getUsersByUsername(@PathVariable String username) {
        return userService.getUsersByUsername(username);
    }

    @PostMapping("/users/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean created = userService.createUser(user);

        return new ResponseEntity(created ? "User Created" : "Already Exists", HttpStatus.OK);
    }
}
