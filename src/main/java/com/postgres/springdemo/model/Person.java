package com.postgres.springdemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="person")
public class Person {
    @Id
    private long id;
    private String name;
    private int Age;


    public void setName(String name) {
        this.name = name;

    }
    public void setAge(int Age) {
        this.Age=Age;

    }
}