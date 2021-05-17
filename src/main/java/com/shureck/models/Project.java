package com.shureck.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Project implements Serializable {

    private Long id;
    private String title;
    private String type;
    private String color;
    private String description;
    private Integer days;
    private Double price;
    private Boolean featured;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime launchDate;

    // constructor, getters, and setters removed for brevity
}