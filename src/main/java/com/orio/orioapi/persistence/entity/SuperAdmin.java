package com.orio.orioapi.persistence.entity;

import com.orio.orioapi.util.RoleUtil;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUPER_ADMIN")
public class SuperAdmin extends User{
    public SuperAdmin(long id, RoleUtil role, String lastname, String firstname, String username, String phoneNumber, String email, String password) {
        super(id, role, lastname, firstname, username, phoneNumber, email, password);
    }
}
