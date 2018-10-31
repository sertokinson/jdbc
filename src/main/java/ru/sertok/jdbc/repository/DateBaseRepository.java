package ru.sertok.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ru.sertok.jdbc.utils.Constants.*;

public class DateBaseRepository {
    protected static Connection connection;
    static {
        try {
            connection = DriverManager
                    .getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
