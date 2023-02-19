package ru.homework.authorizationapp.model;

import java.util.List;

public class User {

    private String user;
    private String password;
    private Authorities[] authorities;
    public User(String user, String password, Authorities[] authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities () {
        return List.of(authorities);
    }
}
