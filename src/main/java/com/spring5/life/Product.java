package com.spring5.life;

import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Product.setName: " + name);
        this.name = name;
    }

    /**
     * 快捷键 soutm
     * <p>
     * 测试scope="singleton"
     */
    public Product() {
        System.out.println("Product.Product:测试scope=\"singleton\"");
    }

    /**
     * 手动写一个初始化方法
     */
    public void myInit() {
        System.out.println("Product2.myInit");
    }

    /**
     * 我们需要实现的初始化方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet");
    }
}
