package com.spring5.basic;

import com.spring5.basic.constructer.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.plugin.security.JDK11ClassFileTransformer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SpringTest {

    @Test
    public void test1() {
//        UserService userService = new UserServiceImpl();
//        UserService userService = BeanFactory.getUserService();
        UserService userService = (UserService) BeanFactory.getBean("userService");
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

    /**
     * 测试 私有化构造方法 的类 可以被创建
     */
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println("user = " + user);
    }

    /**
     * 普通的set方法注入
     */
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        person.setId(1);
        person.setName("张三");
        System.out.println("person = " + person);
    }

    /**
     * 用spring工厂set注入--普通类型+String
     */
    @Test
    public void test8() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        System.out.println("person = " + person);
    }

    /**
     * 用spring工厂set注入--数组类型
     */
    @Test
    public void test9() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        String[] emails = person.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }
    }

    /**
     * 用spring工厂set注入--Set集合
     */
    @Test
    public void test10() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println("tels = " + tel);
        }
    }

    /**
     * 用spring工厂set注入--List集合
     */
    @Test
    public void test11() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        List<String> addresses = person.getAddresses();
        for (String address : addresses) {
            System.out.println("address = " + address);
        }
    }

    /**
     * 用spring工厂set注入--Map集合
     */
    @Test
    public void test12() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        Map<String, String> qqs = person.getQqs();
        for (Map.Entry entry : qqs.entrySet()) {
            System.out.println("key = " + entry.getKey()
                    + ", value = " + entry.getValue());
        }
        System.out.println("======================================");
        final Set<String> strings = qqs.keySet();
        for (String string : strings) {
            System.out.println("key = " + string
                    + ", value = " + qqs.get(string));
        }
    }

    /**
     * 用spring工厂set注入--Properties集合
     */
    @Test
    public void test13() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person2");
        Properties p = person.getP();
        System.out.println("key is k1 value is " + p.get("k1"));
        System.out.println("key is k2 value is " + p.get("k2"));
        System.out.println("key is k3 value is " + p.get("k3"));
    }

    /**
     * 用spring工厂set注入--用户自定义的成员变量：userDAO
     * 第一种方式
     */
    @Test
    public void test14() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("zhangsan", "12345678");
    }

    /**
     * 用spring工厂set注入--用户自定义的成员变量：userDAO
     * 第二种方式
     */
    @Test
    public void test15() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService2");
        userService.login("zhangsan", "12345678");
    }

    /**
     * 用spring工厂set注入--用户自定义的成员变量：userDAO
     * 第二种方式.简化写法：基于属性的简化
     */
    @Test
    public void test16() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService3");
        userService.login("zhangsan", "12345678");
    }

    /**
     * 用spring工厂set注入--用户自定义的成员变量：userDAO
     * 第二种方式.简化写法：基于p命名空间的简化
     */
    @Test
    public void test17() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService4");
        userService.login("zhangsan", "12345678");
        System.out.println("=================================");
        Person person3 = (Person) ctx.getBean("person3");
        System.out.println("person3 = " + person3);
    }

    /**
     * 测试构造器注入
     */
    @Test
    public void test18() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }

    /**
     * 构造方法注入：当构造方法发生重载的时候，通过标签<constructor-arg>的个数来区分
     * 调用了只有name参数的构造方法
     */
    @Test
    public void test19() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer1 = (Customer) ctx.getBean("customer1");
        System.out.println("customer1 = " + customer1);
    }

    /**
     * 构造方法注入：当构造方法发生重载的时候，且标签<constructor-arg>的个数相同时，在标签中添加 type属性
     * 只给age赋值
     */
    @Test
    public void test20() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer2 = (Customer) ctx.getBean("customer2");
        System.out.println("customer2 = " + customer2);
    }
    /**
     * 构造方法注入：当构造方法发生重载的时候，且标签<constructor-arg>的个数相同时，在标签中添加 type属性
     * 只给name赋值
     */
    @Test
    public void test21() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer3 = (Customer) ctx.getBean("customer3");
        System.out.println("customer3 = " + customer3);
    }

    // 控制反转。依赖注入

}
