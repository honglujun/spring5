package com.spring5;

import com.spring5.proxy.OrderService;
import com.spring5.proxy.OrderServiceImplProxy;
import com.spring5.proxy.User;
import com.spring5.proxy.UserService;
import com.spring5.proxy.UserServiceImplProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

    /**
     * 测试静态代理类
     */
    @Test
    public void test1() {
        UserService userService = new UserServiceImplProxy();
        userService.login("zhangsan", "password");
        userService.register(new User());
        System.out.println("=================================");
        OrderService orderService = new OrderServiceImplProxy();
        orderService.showOrder();

    }

    /**
     * 测试动态代理
     * <p>
     * 注意：
     * 1. Spring的⼯⼚通过原始对象的id值获得的是代理对象
     * 2. 获得代理对象后，可以通过声明接⼝类型，进⾏对象的存储
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 这里是通过原始对象的 id值（userService）来获取 代理对象
        // 获得代理对象后，可以通过声明接⼝类型(UserService)，进⾏对象的存储
        UserService userService = (UserService) ctx.getBean("userService");
        UserService userService2 = (UserService) ctx.getBean("userService2");
        userService.register(new User());
        boolean login = userService.login("zhangsan", "password");
        boolean login2 = userService2.login("zhangsan", "password");
        System.out.println("TestProxy.test2: " + login);
        System.out.println("TestProxy.test2.login2: " + login2);
    }

    /**
     * 测试orderService的动态代理
     */
    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();
    }
}
