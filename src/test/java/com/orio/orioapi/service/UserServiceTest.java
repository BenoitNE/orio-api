package com.orio.orioapi.service;

import com.orio.orioapi.persistence.entity.Admin;
import com.orio.orioapi.persistence.entity.SuperAdmin;
import com.orio.orioapi.persistence.entity.User;
import com.orio.orioapi.persistence.repository.UserRepository;
import com.orio.orioapi.service.impl.UserServiceImpl;
import com.orio.orioapi.util.RoleUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAllUsers() {
        // Given
        User user1 = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        User user2 = new SuperAdmin(2, RoleUtil.SUPER_ADMIN,"lastnameUser2","firstnameUser2","usernameUser2","123456789","user2@orio-api.com","azerty");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // When
        List<User> users = userService.getAllUsers();

        // Then
        assertEquals(2, users.size());
        assertEquals(user1, users.get(0));
        assertEquals(user2, users.get(1));
    }

    @Test
    void testGetUserById() {
        // Given
        long userId = 1;
        User user = new Admin(userId, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        Optional<User> result = userService.getUserById(userId);

        // Then
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testGetUserByUsername() {
        // Given
        String username = "user1";
        User user = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1",username,"123456789","user1@orio-api.com","azerty");
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // When
        Optional<User> result = userService.getUserByUsername(username);

        // Then
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testSaveUser() {
        // Given
        User user = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        when(userRepository.save(user)).thenReturn(user);

        // When
        User savedUser = userService.saveUser(user);

        // Then
        assertEquals(user, savedUser);
    }

    @Test
    void testDeleteUser() {
        // Given
        long userId = 1;

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }
}
