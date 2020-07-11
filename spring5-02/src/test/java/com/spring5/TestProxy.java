package com.spring5;

import com.spring5.proxy.OrderService;
import com.spring5.proxy.OrderServiceImplProxy;
import com.spring5.proxy.User;
import com.spring5.proxy.UserService;
import com.spring5.proxy.UserServiceImplProxy;
import org.junit.Test;

public class TestProxy {

    /**
     * 测试静态代理类
     */
    @Test
    public void test1(){
        UserService userService = new UserServiceImplProxy();
        userService.login("zhangsan","password");
        userService.register(new User());
        System.out.println("=================================");
        OrderService orderService = new OrderServiceImplProxy();
        orderService.showOrder();

    }
}
