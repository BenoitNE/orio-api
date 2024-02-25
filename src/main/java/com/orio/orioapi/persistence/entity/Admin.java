package com.orio.orioapi.persistence.entity;

import com.orio.orioapi.util.RoleUtil;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User{

    public Admin(long id, RoleUtil role, String lastname, String firstname, String username, String phoneNumber, String email, String password) {
        super(id, role, lastname, firstname, username, phoneNumber, email, password);
    }
}
