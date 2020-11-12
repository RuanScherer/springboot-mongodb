package com.ruanscherer.springboot_mongodb.resources;

import com.ruanscherer.springboot_mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("ABCDEFG", "Ruan", "ruan.vscherer@gmail.com");
        User user1 = new User("ABCDEFf", "Nicolas", "nicolas@gmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(user, user1));
        return ResponseEntity.ok().body(users);
    }
}
