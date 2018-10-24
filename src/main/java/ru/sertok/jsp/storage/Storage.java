package ru.sertok.jsp.storage;

import ru.sertok.jsp.entities.User;
import ru.sertok.jsp.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    // переменная, которая хранит ссылку на единственный экземпляр объекта класса Storage
    private static final Storage storage;

    // статически инициализатор, создающий объект класса Storage. Вызывается один раз при загрузке класса в JVM
    static {
        storage = new Storage();
    }

    // поле-список, хранящее список пользователей системы
    private List<User> users;

    // приватный констуктор, выполняющий инициализацию списка
    private Storage() {
        this.users = new ArrayList<>();
        users.add(new User("Сергей", Utils.hash("12355789"), LocalDate.parse("1994-02-12")));
    }

    // метод, предоставляющий доступ к объекту класса
    public static Storage storage() {
        return storage;
    }

    // метод, возвращающий список пользователей
    public List<User> users() {
        return users;
    }
}