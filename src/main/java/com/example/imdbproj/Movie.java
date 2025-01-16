package com.example.imdbproj;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
public class Movie {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Basic(optional = false)
 @Column(name = "tconst")
 private String tconst;

 private String titleType;
 private String  primaryTitle;
 private String  originalTitle;
 private boolean  isAdult;
 private LocalDate startYear;
 private LocalDate  endYear;
 private long  runtimeMinutes;
 private String[] genres;


}
