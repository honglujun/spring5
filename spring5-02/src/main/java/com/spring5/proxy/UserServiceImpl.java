package com.spring5.proxy;

/**
 * 原始类（目标类）
 */
public class UserServiceImpl implements UserService {

    /**
     * soutm快捷打印
     *
     * @param user
     */
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}
