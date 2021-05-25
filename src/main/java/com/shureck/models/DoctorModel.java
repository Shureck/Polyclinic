package com.shureck.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoctorModel {
    private String firstName;
    private String lastName;
    private String middleName;
    private String specialtys;

    private String email;
    private String phoneNumber;

    @Override
    public String toString() {
        return "DoctorModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", specialtys='" + specialtys + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}