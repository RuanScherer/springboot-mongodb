package com.ruanscherer.springboot_mongodb.resources;

import com.ruanscherer.springboot_mongodb.domain.Post;
import com.ruanscherer.springboot_mongodb.domain.User;
import com.ruanscherer.springboot_mongodb.dto.UserDTO;
import com.ruanscherer.springboot_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> usersResponse = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable final String id) {
        User user = userService.findById(id);
        UserDTO response = new UserDTO(user);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody final UserDTO userDTO) {
        User user = userService.insert(userService.fromDTO(userDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable final String id,
                                          @RequestBody User user) {
        user = userService.update(id, user);
        UserDTO response = new UserDTO(user);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable final String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
