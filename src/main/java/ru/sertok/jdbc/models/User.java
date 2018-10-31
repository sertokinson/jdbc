package ru.sertok.jdbc.models;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Getter
public class User {
    private Integer id;
    private String name;
    private String password;
    private Date birthDate;

    private void setId(Integer id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

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

}
