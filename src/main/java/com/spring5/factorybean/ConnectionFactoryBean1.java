package com.spring5.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean1 implements FactoryBean<Connection> {
    private String driver;
    private String url;
    private String username;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 用于书写创建复杂对象时的代码。
    @Override
    public Connection getObject() throws Exception {
        Class<?> clazz = Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
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

    @Override
    public String toString() {
        return "ConnectionFactoryBean1{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
