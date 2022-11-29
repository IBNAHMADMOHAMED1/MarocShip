package com.example.marocship.controllers;

import com.example.marocship.beans.Alert;
import com.example.marocship.beans.Auth;
import com.example.marocship.beans.Login;
import com.example.marocship.dao.PersonDao;
import com.example.marocship.entities.DeliveryManager;
import com.example.marocship.entities.Driver;
import com.example.marocship.entities.Manager;
import com.example.marocship.entities.Person;
import com.example.marocship.helpers.Enum;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class LoginController implements Serializable {

    @Inject
    Login credentials;

    @Inject
    Alert alert;

    @Inject
    Auth auth;

    public String login() {
        Class clazz = Manager.class;
        auth.setRole(Enum.role.MANAGER.toString());
        String redirectTo = "index";
        if(credentials.getRole().equals(Enum.role.DELIVERY_MANAGER.toString())){
            clazz = DeliveryManager.class;
            auth.setRole(Enum.role.DELIVERY_MANAGER.toString());
            redirectTo = "newDelivery";
        } else if(credentials.getRole().equals(Enum.role.DRIVER.toString())) {
            clazz = Driver.class;
            auth.setRole(Enum.role.DRIVER.toString());
            redirectTo = "driver";
        }
        Person person = new PersonDao<>().userExist(credentials.getEmail(),credentials.getPassword(), clazz);
        if(person != null) {
            auth.setUser(person);
            return redirectTo+"?faces-redirect=true";
        }
        else alert.setMessage("Wrong email or password!");
        return "";
    }

}
