package com.orio.orioapi.service;

import com.orio.orioapi.persistence.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    Optional<User> getUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(long id);

}
