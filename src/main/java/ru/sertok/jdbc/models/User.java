package ru.sertok.jdbc.models;


import java.sql.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Date birthDate;

    public User() { }

    public User withName(String name){
        setName(name);
        return this;
    }

    public User withPassword(String password){
        setPassword(password);
        return this;
    }

    public User withBirthDate(Date birthDate){
        setBirthDate(birthDate);
        return this;
    }

    public User withId(Integer id){
        setId(id);
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
