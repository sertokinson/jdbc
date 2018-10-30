package ru.sertok.jdbc.repository.impl;

import ru.sertok.jdbc.entities.User;
import ru.sertok.jdbc.repository.api.Repository;
import ru.sertok.jdbc.utils.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ru.sertok.jdbc.utils.Constants.*;

public class DateBaseRepository implements Repository {
    private static Connection connection;
    private Statement statement;
    private String[] mutableHash = new String[1];

    static {
        try {
            connection = DriverManager
                    .getConnection(DB_URL, DB_USER, DB_PASSWORD);
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

    private List<User> createListUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new LinkedList<>();
        while (resultSet.next())
            users.add(
                    new User(
                            resultSet.getString("name"),
                            resultSet.getString("password"),
                            resultSet.getDate("birthDate"))
            );
        return users;
    }

    @Override
    public List findAll() {
        List<User> users = new LinkedList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fix_user");
            users = createListUsers(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO fix_user (name, password, birthdate) VALUES (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setDate(3, user.getBirthDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean isExist(String name, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT*FROM fix_user WHERE name = ?");
            preparedStatement.setString(1,name);
            List<User> listUsers = createListUsers(preparedStatement.executeQuery());
            for (User user : listUsers) {
                if (user.getName().equals(name) && Utils.verifyAndUpdateHash(password, user.getPassword(), hash -> {
                    mutableHash[0] = hash;
                    return true;
                }))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
