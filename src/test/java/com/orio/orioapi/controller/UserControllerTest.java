package com.orio.orioapi.controller;

import com.orio.orioapi.persistence.entity.Admin;
import com.orio.orioapi.persistence.entity.SuperAdmin;
import com.orio.orioapi.persistence.entity.User;
import com.orio.orioapi.service.UserService;
import com.orio.orioapi.util.RoleUtil;
import com.orio.orioapi.web.controller.UserController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {
        // Given
        User user1 = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        User user2 = new SuperAdmin(2, RoleUtil.SUPER_ADMIN,"lastnameUser2","firstnameUser2","usernameUser2","123456789","user2@orio-api.com","azerty");
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // When
        List<User> users = userController.getAllUsers();

        // Then
        assertEquals(2, users.size());
        assertEquals(user1, users.get(0));
        assertEquals(user2, users.get(1));
    }

    @Test
    void testGetUserById() {
        // Given
        long userId = 1;
        User user = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        when(userService.getUserById(userId)).thenReturn(Optional.of(user));

        // When
        ResponseEntity<User> responseEntity = userController.getUserById(userId);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    void testGetUserByIdNotFound() {
        // Given
        long userId = 1;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<User> responseEntity = userController.getUserById(userId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testCreateUser() {
        // Given
        User user = new Admin(1, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        when(userService.saveUser(user)).thenReturn(user);

        // When
        ResponseEntity<User> responseEntity = userController.createUser(user);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    void testUpdateUser() {
        // Given
        long userId = 1;
        User existingUser = new Admin(userId, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        User updatedUser = new Admin(userId, RoleUtil.ADMIN,"updatedLastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");
        when(userService.getUserById(userId)).thenReturn(Optional.of(existingUser));
        when(userService.saveUser(updatedUser)).thenReturn(updatedUser);

        // When
        ResponseEntity<User> responseEntity = userController.updateUser(userId, updatedUser);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedUser, responseEntity.getBody());
    }

    @Test
    void testUpdateUserNotFound() {
        // Given
        long userId = 1;
        User updatedUser = new Admin(userId, RoleUtil.ADMIN,"updatedLastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty");;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<User> responseEntity = userController.updateUser(userId, updatedUser);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testDeleteUser() {
        // Given
        long userId = 1;
        when(userService.getUserById(userId)).thenReturn(Optional.of(new Admin(userId, RoleUtil.ADMIN,"lastnameUser1","lastnameUser1","usernameUser1","123456789","user1@orio-api.com","azerty")));

        // When
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }

    @Test
    void testDeleteUserNotFound() {
        // Given
        long userId = 1;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        // When
        ResponseEntity<Void> responseEntity = userController.deleteUser(userId);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(userService, never()).deleteUser(userId);
    }
}

