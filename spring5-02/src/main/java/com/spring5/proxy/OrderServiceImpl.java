package com.spring5.proxy;

public class OrderServiceImpl implements OrderService {
    @Override
    public void showOrder() {
        System.out.println("OrderServiceImpl.showOrder");
//        throw new RuntimeException("原始方法抛出异常");
    }
}
