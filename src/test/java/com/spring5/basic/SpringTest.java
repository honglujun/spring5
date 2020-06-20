package com.spring5.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test1() {
//        UserService userService = new UserServiceImpl();
//        UserService userService = BeanFactory.getUserService();
        UserService userService = (UserService)BeanFactory.getBean("userService");
        userService.login("张三", "123123");

        User user = new User("张三", "123123");
        userService.register(user);
    }


    @Test
    public void test3() {
        // 1.获取spring的工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 2.通过工厂类 获取对象
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 指定名字（唯一标识）和全限定名，就不用像test3那样进行强转了
//        Person person = ctx.getBean("person", Person.class);
//        System.out.println("person = " + person);

        // 当前Spring的配置文件中，只能有 一个bean 的class是Person类型
//        Person bean = ctx.getBean(Person.class);
//        System.out.println("bean = " + bean);

        // 获取Spring工厂配置文件中所有bean标签的id值 person person1
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("beanDefinitionName = " + beanDefinitionName);
//        }

        // 根据类型获得spring配置文件中对应的id值
//        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
//        for (String id : beanNamesForType) {
//            System.out.println("id = " + id);
//        }

        // 判断是否有指定id值的bean,不能判断name属性的值
//        if (ctx.containsBeanDefinition("a")){
//            System.out.println("true = "+ true );
//        } else {
//            System.out.println("false = " + false);
//        }

        // 判断是否有指定id值的bean,也能判断name属性的值
        if (ctx.containsBean("person")) {
            System.out.println("true = " + true);
        } else {
            System.out.println("false = " + false);
        }

    }

    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过name属性 别名 获取对象
//        Person person = ctx.getBean("p", Person.class);
//        System.out.println("person = " + person);
        // 只有class属性也是可以获取对象的
        User user = ctx.getBean(User.class);
        System.out.println("user = " + user);
        // spring 会给没有id的bean设置一个默认的id ：com.spring5.basic.User#0
        final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


}
