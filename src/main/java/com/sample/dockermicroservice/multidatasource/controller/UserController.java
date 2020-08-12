
package com.sample.dockermicroservice.multidatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.user.domain.User;
import com.sample.dockermicroservice.multidatasource.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User userdetails(@PathVariable("id") Long id) {
        return userService.getUserDetails(id);
    }

    @PostMapping
    public User newUser(@RequestBody User user) throws ValidationException  {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws ValidationException  {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
    
}
