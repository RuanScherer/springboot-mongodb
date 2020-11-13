package com.ruanscherer.springboot_mongodb.config;

import com.ruanscherer.springboot_mongodb.domain.Post;
import com.ruanscherer.springboot_mongodb.domain.User;
import com.ruanscherer.springboot_mongodb.dto.AuthorDTO;
import com.ruanscherer.springboot_mongodb.repositories.PostRepository;
import com.ruanscherer.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(
                null,
                sdf.parse("12/11/2020"),
                "Estou indo viajar",
                "Bali me aguarde!",
                new AuthorDTO(maria)
        );
        postRepository.save(post1);
    }
}
