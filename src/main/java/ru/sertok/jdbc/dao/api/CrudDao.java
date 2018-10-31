package ru.sertok.jdbc.dao.api;

import java.util.List;

public interface CrudDao<T> {
    void save(T model);
    T find (Integer id);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}
