package social.Network.projectsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.security.email.RegistrationRequest;
import social.Network.projectsocial.service.UserService;

@RestController
@RequestMapping("/registration")
public class LoginController {

    @Autowired
    private UserService userService;
//
//    @PostMapping("/register")
//    public User create_User(@RequestBody User user){
//        return userService.createUser(user);
//    }
//    @PostMapping("/register")
//    public ResponseEntity<User> createNewUser(@RequestBody User user){
//        User newUser = userService.createUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//
//    }

    @PostMapping()
    public String register (@RequestBody RegistrationRequest request){

        return userService.register(request);
    }
    @GetMapping("/confirm")
    public String confirm (@RequestParam("token") String token){
        return userService.confirmToken(token);
    }

}
