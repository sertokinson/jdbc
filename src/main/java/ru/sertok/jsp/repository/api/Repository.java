package ru.sertok.jsp.repository.api;

import ru.sertok.jsp.entities.User;

import java.util.List;

public interface Repository {
    List findAll();
    void save(User user);
    Boolean isExist(String name,String password);
}
