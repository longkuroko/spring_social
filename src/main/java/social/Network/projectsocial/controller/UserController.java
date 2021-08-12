package social.Network.projectsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import social.Network.projectsocial.model.User;
import social.Network.projectsocial.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
//        User user = userService.findUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    @GetMapping("/find/{code}")
    public ResponseEntity<User> getUserByUserCode(@PathVariable("code") String code){
        User user = userService.findUserByUserCode(code);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
