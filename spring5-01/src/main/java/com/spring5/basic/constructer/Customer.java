package com.spring5.basic.constructer;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private Integer age;

    public Customer(Integer age) {
        this.age = age;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
