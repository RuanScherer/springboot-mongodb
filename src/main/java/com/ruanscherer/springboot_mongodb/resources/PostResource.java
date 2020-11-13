package com.ruanscherer.springboot_mongodb.resources;

import com.ruanscherer.springboot_mongodb.domain.Post;
import com.ruanscherer.springboot_mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }
}
