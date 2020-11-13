package com.ruanscherer.springboot_mongodb.repositories;

import com.ruanscherer.springboot_mongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
