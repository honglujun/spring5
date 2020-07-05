package com.spring5.life;

import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean {
    /**
     * 快捷键 soutm
     * <p>
     * 测试scope="singleton"
     */
    public Product() {
        System.out.println("Product.Product:测试scope=\"singleton\"");
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
