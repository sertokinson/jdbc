package ru.sertok.jdbc.repository;

import ru.sertok.jdbc.dao.impl.UserDao;

public class ConnectionUserDao extends DateBaseRepository{
    private UserDao userDao;

    public ConnectionUserDao() {
        userDao = new UserDao(connection);
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
