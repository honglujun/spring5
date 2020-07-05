package com.spring5.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {

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
    public void myInit() throws Exception{
        System.out.println("Product2.myInit" + Product.this);
    }

    /**
     * 我们需要实现 InitializingBean 的 afterPropertiesSet 方法初始化
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product.afterPropertiesSet"  + Product.this);
    }

    /**
     * 手动写一个初销毁方法
     */
    public void myDestroy() throws Exception{
        System.out.println("Product2.myDestroy"  + Product.this);
    }

    /**
     * 手动实现的 DisposableBean 的destroy方法销毁对象
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy:" + Product.this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
