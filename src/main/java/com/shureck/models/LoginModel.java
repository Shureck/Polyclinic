package com.shureck.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginModel {
    private String login;
    private String pass;

    @Override
    public String toString() {
        return "LoginModel{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
