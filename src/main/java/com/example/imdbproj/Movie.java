package com.example.imdbproj;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Movie {

/*
 @Basic(optional = false)
*/
/*
 @Column(name = "tconst")
*/
 @Id
 private String tconst;


 private String titleType;
 private String  primaryTitle;
 private String  originalTitle;
 private boolean  isAdult;
 private LocalDate startYear;
 private LocalDate  endYear;
 private long  runtimeMinutes;
 private String genres; // Store as a comma-separated string

 public Movie(){
 }

 public String getTconst(){
  return  tconst;
 }

 public void setTconst(String tconst){
  this.tconst = tconst;
 }

 public String getPrimaryTitle(){
   return primaryTitle;
 }

 public void setPrimaryTitle(String primaryTitle){
   this.primaryTitle = primaryTitle;
 }

 public String getTitleType(){
  return titleType;
 }

 public void setTitleType(String titleType){
  this.titleType = titleType;
 }

 public String[] getGenres() {
  return genres.split(",");
 }

 public void setGenres(String[] genres) {
  this.genres = String.join(",", genres);
 }

}
