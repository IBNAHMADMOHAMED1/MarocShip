package com.example.marocship.entities;

import jakarta.persistence.*;

@Entity
public class Admin extends Person{

    public Admin() {
    }

    public Admin(long personId, String email, String username, String password) {
        super(personId, email, username, password);
    }

}
