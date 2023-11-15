package com.example.demo;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
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
}