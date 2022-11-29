package com.example.marocship.beans;

import com.example.marocship.entities.Person;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class Auth implements Serializable {
    private Person user;
    private String role;

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean authenticated(){
        return this.user != null;
    }

    public boolean authorized(String role){
        return authenticated() && role.equals(this.role);
    }
}
