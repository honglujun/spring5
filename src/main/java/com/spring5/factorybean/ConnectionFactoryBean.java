package com.spring5.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
    // 用于书写创建复杂对象时的代码。
    @Override
    public Connection getObject() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoai?useSSL=false", "root", "root");
        return conn;
    }

    // 返回创建的复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    // 是否单例
    @Override
    public boolean isSingleton() {
        return false; // 每一次都创建新的复杂对象
        // return true; // 只创建一次这种类型的复杂对象
    }
}
