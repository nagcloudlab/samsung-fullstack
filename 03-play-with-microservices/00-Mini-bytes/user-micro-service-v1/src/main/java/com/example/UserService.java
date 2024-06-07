package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user); // blocking DB call
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll(); // blocking DB call
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
