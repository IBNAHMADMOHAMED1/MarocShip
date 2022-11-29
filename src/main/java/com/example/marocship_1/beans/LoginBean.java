package com.example.marocship_1.beans;

import com.example.marocship_1.dao.AdminDao;
import com.example.marocship_1.entity.Admin;
import java.io.Serializable;

import com.example.marocship_1.view.SpotlightView;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;



@Named
@RequestScoped
public class LoginBean implements Serializable {

    private Admin admin = new Admin();
    public static Boolean loggedIn = false;
    public static final String HOME_PAGE_REDIRECT = "/home.xhtml?faces-redirect=true";
    public static final String LOGIN_PAGE_REDIRECT = "/";

    @Inject
    private SpotlightView spotlightView;


    public String login() {
        System.out.println("email: " + spotlightView.getEmail());
        System.out.println("-------------------------");
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        admin.setPassword(spotlightView.getPassword());
        admin.setEmail(spotlightView.getEmail());
        AdminDao adminDao = new AdminDao();
        System.out.println(admin.getEmail());
       Admin admin = adminDao.authentification(this.admin.getEmail(), this.admin.getPassword());
        if (admin != null) {

            this.admin = admin;
            loggedIn = true;
            return HOME_PAGE_REDIRECT;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bad credentials"));
        return LOGIN_PAGE_REDIRECT;
    }




}
