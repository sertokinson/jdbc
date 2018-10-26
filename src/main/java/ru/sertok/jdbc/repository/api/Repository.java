package ru.sertok.jdbc.repository.api;

import ru.sertok.jdbc.entities.User;

import java.util.List;

public interface Repository {
    List findAll();
    void save(User user);
    Boolean isExist(String name,String password);
}
