package com.shureck.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginModel {
    private String login;
    private String pass;
    private Boolean vra4;

    @Override
    public String toString() {
        return "LoginModel{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", check=" + vra4 +
                '}';
    }
}
