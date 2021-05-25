package com.shureck.controllers;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "specialtys")
    private String specialtys;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "topic_id")
    private List<Doctor> doctors = new ArrayList<>();

    public Spec(String specialtys) {
        this.specialtys = specialtys;
    }

    public Spec() {

    }

    @Override
    public String toString() {
        return "Spec{" +
                "id=" + id +
                ", specialtys='" + specialtys + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        Doctor doctor = (Doctor) obj;
        for (int i = 0; i < this.getDoctors().size(); i++) {
            if(this.getDoctors().get(i).getFirstName() == doctor.getFirstName()
                || this.getDoctors().get(i).getLastName() == doctor.getLastName()
                    || this.getDoctors().get(i).getMiddleName() == doctor.getMiddleName()){
                return true;
            }
        }
        return false;
    }
}
