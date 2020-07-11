package com.spring5.proxy;

public class OrderServiceImplProxy implements OrderService {
    // 创建一个目标类
    private OrderService orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        // 额外的功能（日志，事务等等）
        System.out.println("================log===============");
        // 目标类（原始类）中要实现的方法
        orderService.showOrder();
    }
}
