package com.ruanscherer.springboot_mongodb.services;

import com.ruanscherer.springboot_mongodb.domain.User;
import com.ruanscherer.springboot_mongodb.dto.UserDTO;
import com.ruanscherer.springboot_mongodb.exceptions.ObjectNotFoundException;
import com.ruanscherer.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(final String id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return user.get();
        } catch (NoSuchElementException exception) {
            throw new ObjectNotFoundException(exception.getMessage());
        }
    }

    public User insert(final User user) {
        return userRepository.save(user);
    }

    public void delete(final String id) {
        userRepository.deleteById(id);
    }

    public User update(final String id, final User user) {
        try {
            User dbUser = userRepository.findById(id).get();
            this.updateData(user, dbUser);
            userRepository.save(dbUser);
            return dbUser;
        } catch (NoSuchElementException exception) {
            throw new ObjectNotFoundException(exception.getMessage());
        }
    }

    public void updateData(final User from, final User to) {
        to.setName(from.getName());
        to.setEmail(from.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
