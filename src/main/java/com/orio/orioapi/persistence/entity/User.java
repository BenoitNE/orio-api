package com.orio.orioapi.persistence.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.orio.orioapi.util.RoleUtil;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "auth_role", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "role")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = SuperAdmin.class, name = "SUPER_ADMIN"),
})
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private RoleUtil role;
    private String lastname;
    private String firstname;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;

    public User() {
    }

    public User(long id, RoleUtil role, String lastname, String firstname, String username, String phoneNumber, String email, String password) {
        this.id = id;
        this.role = role;
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
