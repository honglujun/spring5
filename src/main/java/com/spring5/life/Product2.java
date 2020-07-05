package com.spring5.life;

public class Product2 {
    /**
     * 生成打印语句的快捷键 soutm
     */
    public Product2() {
        System.out.println("Product2.Product2：测试scope=\"prototype\"");
    }

    /**
     * 手动写一个初始化方法
     */
    public void myInit() {
        System.out.println("Product2.myInit");
    }

}
