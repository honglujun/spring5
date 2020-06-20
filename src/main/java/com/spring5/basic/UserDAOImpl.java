package com.spring5.basic;

public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user) {
        System.out.println("insert into table user =" + user);
    }

    @Override
    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("select user= " + name + " ,password= " + password);
    }
}
