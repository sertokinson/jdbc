package ru.sertok.jdbc.repository.impl;

import ru.sertok.jdbc.entities.User;
import ru.sertok.jdbc.repository.api.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DateBaseRepository implements Repository {
    private static Connection connection;
    private Statement statement;

    static {
        try {
             connection = DriverManager
                    .getConnection("jdbc:postgresql://127.0.0.1:5432/jdbc", "postgres", "12355789");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DateBaseRepository() {
        try {
             statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findAll() {
        List<User> users = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fix_user");
            while (resultSet.next())
                users.add(
                        new User(
                                resultSet.getString("name"),
                                resultSet.getString("password"),
                                resultSet.getDate("birthDate"))
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Boolean isExist(String name, String password) {
        throw new UnsupportedOperationException();
    }
}
