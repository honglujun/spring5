package com.spring5.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static Properties env = new Properties();

    /**
     * 读取 applicationContext.properties 文件
     */
    static {
        try {
            // 1.获取io流
            InputStream resourceAsStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            // 2.获取properties的key userDAO 对应的value com.spring5.basic.UserDAOImpl
            env.load(resourceAsStream);
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单的工厂
     * @return
     */
//    public static UserDAO getUserDAO(){
//        return new UserDAOImpl();
//    }
//    public static UserService getUserService(){
//        return new UserServiceImpl();
//    }

    /**
     * 反射工厂方法
     */
    public static UserDAO getUserDAO() {
        UserDAO userDAO = null;
        try {
//            Class clazz = Class.forName("com.spring5.basic.UserDAOImpl");
            // 将反射的类名的全路径名称添加到配置文件
            Class clazz = Class.forName(env.getProperty("userDAO"));
            userDAO = (UserDAO) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDAO;
    }

    public static UserService getUserService() {
        UserService userService = null;
        try {
//            Class clazz = Class.forName("com.spring5.basic.UserServiceImpl");
            // 将反射的类名的全路径名称添加到配置文件
            Class clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService;
    }

    /**
     * 通用反射工厂方法
     *
     * @param key
     * @return
     */
    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}
