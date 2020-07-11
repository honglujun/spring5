package com.spring5.proxy;

public interface UserService {
    void register(User user);

    void login(String name, String password);
}
