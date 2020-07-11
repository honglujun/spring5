package com.spring5.proxy;

public interface UserService {
    void register(User user);

    boolean login(String name, String password);
}
