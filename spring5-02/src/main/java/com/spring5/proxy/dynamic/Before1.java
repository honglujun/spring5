package com.spring5.proxy.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {
    /**
     * 作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     *
     * @param method 额外功能所增加给的那个原始方法
     *               login方法
     *               register方法
     *               showOrder方法
     * @param objects 额外功能所增加的那个原始方法的参数。String name，String password
     *                                              User user
     * @param target 额外功能所增加的那个原始对象 UserServiceImpl
     *                                       OrderServiceImpl
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("==========new method before advice log===================");
    }
}
