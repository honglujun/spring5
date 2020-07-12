package com.spring5.proxy.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {
    /**
     * 作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     *
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("==========new method before advice log===================");
    }
}