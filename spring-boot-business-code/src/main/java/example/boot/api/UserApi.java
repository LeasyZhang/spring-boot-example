package example.boot.api;

import example.boot.observer.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/{userName}")
    public ResponseEntity<String> register(@PathVariable("userName") String userName) {
        userService.register(userName);
        return ResponseEntity.ok("Register success");
    }
}
