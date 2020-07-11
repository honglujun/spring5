package com.spring5.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;

public class StaticConnectionFactory {

    public static Connection getConnection() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoai?useSSL=false", "root", "root");
        return conn;
    }
}
