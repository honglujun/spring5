package com.spring5.proxy.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 额外功能的
 */
public class Around  implements MethodInterceptor {
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
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("====原始方法执行之前执行=====");
        // 额外功能所执行的原始方法
        Object ret = invocation.proceed();
        System.out.println("====原始方法执行之后执行=====");
        return ret;
    }
}
