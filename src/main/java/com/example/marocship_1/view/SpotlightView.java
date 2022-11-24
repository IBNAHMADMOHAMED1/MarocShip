package com.example.marocship_1.view;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@RequestScoped
public class SpotlightView {

    private String password;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.password = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void save() {
        password = null;
        email = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've registered"));
    }


}