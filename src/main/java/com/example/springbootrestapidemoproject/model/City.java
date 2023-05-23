package com.example.springbootrestapidemoproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class City {
    @DateTimeFormat(pattern = "dd-MM-yyyy")

    private int id;
    private String name;




    private Date date;
public City(int id,String name){
    this.id=id;
    this.name=name;

}
public City(){

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
