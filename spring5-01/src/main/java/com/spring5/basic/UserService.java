package com.spring5.basic;

public interface UserService {
    void register(User user);

    void login(String name, String password);
}
