package com.example.marocship_1.dao;

import com.example.marocship_1.entity.Admin;
import com.example.marocship_1.utlis.BCrypt;

public class AdminDao extends HibernateDao<Admin> {
    private static Admin entity = new Admin();

    public AdminDao() {
        setClazz(Admin.class);
    }

    public Admin authentification(String email, String password) {
        Admin admin = getByField("email", email);
        if (admin != null ) {
            if ( BCrypt.checkpw(password, admin.getPassword())) {
                return admin;
            }
        }
        return null;
    }

    public Admin createAdmin(Admin admin) {
        admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));
        return create(admin);
    }


}
