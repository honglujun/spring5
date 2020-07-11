package com.spring5.proxy;

public class UserServiceImplProxy implements UserService{
    // 创建目标类
    private UserService userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        // 代理类中需要实现的额外方法
        System.out.println("=========log============");
        // 目标类（原始类）中要实现的方法
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        // 代理类中需要实现的额外方法
        System.out.println("=========log============");
        // 目标类（原始类）中要实现的方法
        return userService.login(name,password);
    }
}
