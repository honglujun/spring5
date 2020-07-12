package com.spring5.proxy.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 额外功能的
 */
public class Around1 implements MethodInterceptor {
    /**
     * invoke方法的作用：额外功能书写在invoke方法中
     *                 额外功能可以书写在  原始方法之前
     *                 额外功能可以书写在  原始方法之后
     *                 额外功能可以书写在  原始方法之前 之后
     * 确定：原始方法怎么运行
     *
     * @param invocation（与MethodBeforeAdvice接口的Method参数相同）：额外功能所增加的原始方法
     *                  login()
     *                  register()
     *                  invocation.proceed() ---> login运行
     *                                            register运行
     *
     * @return Object 原始方法的返回值
     *                这个返回值是可以影响原始方法的返回值的：
     *                若invoke方法的invocation.proceed()的结果作为返回值直接返回，则不会影响返回结果
     *                若invoke方法的invocation.proceed()的结果被这里的方法修改了，返回的结果就会随之改变
     *                针对UserServiceImpl的login方法做测试：这个login方法返回的是true，但是在这里的return的是false，所以结果应该是false
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("====原始方法执行之前执行=====");
        // 额外功能所执行的原始方法
        Object ret =  invocation.proceed();

        return false;
    }
}
