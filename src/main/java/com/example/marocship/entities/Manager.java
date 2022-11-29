package com.example.marocship.entities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Entity
public class Manager extends Person{

    public Manager() {
    }

    public Manager(long personId, String email, String username, String password) {
        super(personId, email, username, password);
    }

}
