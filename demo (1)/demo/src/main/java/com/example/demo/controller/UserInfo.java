package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    public UserInfo() {
    }

    public UserInfo(Long userId, String firstName, String lastName, int age, String gender) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
