package com.example.restserviceproject.entity;

public class ClientDto {
    private int id;
    private String firstName, lastName, surName;

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public ClientDto(int id, String firstName, String lastName, String surName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
    }
}
