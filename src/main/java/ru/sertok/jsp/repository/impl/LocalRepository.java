package ru.sertok.jsp.repository.impl;

import ru.sertok.jsp.entities.User;
import ru.sertok.jsp.repository.api.Repository;
import ru.sertok.jsp.storage.Storage;
import ru.sertok.jsp.utils.Utils;

import java.util.List;

public class LocalRepository implements Repository {
    private String[] mutableHash = new String[1];

    @Override
    public List<User> findAll() {
        return Storage.storage().users();
    }

    @Override
    public void save(User user) {
        Storage.storage().users().add(user);
    }

    @Override
    public Boolean isExist(String name, String password) {
        for (User user: Storage.storage().users()) {
            if(user.getName().equals(name)&& Utils.verifyAndUpdateHash(password,user.getPassword(),hash -> { mutableHash[0] = hash; return true; }))
                return true;
        }
        return false;
    }
}
