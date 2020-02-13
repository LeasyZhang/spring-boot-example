package com.springboot.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @NotNull
    @Min(value = 1, message = "ID should be larger than 1")
    private Long ID;

    @NotNull(message = "name must not be null")
    private String name;

    private String address;

    @NotNull(message = "age is must not be null")
    @Min(value = 10, message = "age must above 10 years old")
    private Integer age;

    @Email(regexp=".@.\\..*", message = "Email should be valid")
    private String email;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
