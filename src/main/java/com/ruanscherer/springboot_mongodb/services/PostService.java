package com.ruanscherer.springboot_mongodb.services;

import com.ruanscherer.springboot_mongodb.domain.Post;
import com.ruanscherer.springboot_mongodb.exceptions.ObjectNotFoundException;
import com.ruanscherer.springboot_mongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(final String id) {
        try {
            Optional<Post> user = postRepository.findById(id);
            return user.get();
        } catch (NoSuchElementException exception) {
            throw new ObjectNotFoundException(exception.getMessage());
        }
    }
}
