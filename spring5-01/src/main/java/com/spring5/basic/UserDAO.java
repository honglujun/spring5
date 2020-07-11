package com.spring5.basic;

public interface UserDAO {
    void save(User user);

    void queryUserByNameAndPassword(String name, String password);
}
