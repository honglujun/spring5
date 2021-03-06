package com.spring5.basic;

import com.spring5.basic.constructer.Customer;
import com.spring5.beanpost.Category;
import com.spring5.factorybean.ConnectionFactoryBean;
import com.spring5.life.Product;
import com.spring5.life.Product2;
import com.spring5.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
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

    /**
     * 测试实现FactoryBean接口的类
     * <p>
     * 复杂对象的bean：class中指定的类型 是FactoryBean接口的实现类(ConnectionFactoryBean)，
     * 那么通过id值获取的是这个类(ConnectionFactoryBean)所创建的复杂对象 Connection
     */
    @Test
    public void test22() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回true：只创建一次这种类型的复杂对象
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回false：每一次都创建新的复杂对象
        System.out.println("conn = " + conn);
        System.out.println("conn = " + conn);
    }

    /**
     * 测试实现FactoryBean接口的类
     * <p>
     * 复杂对象的bean：class中指定的类型 是FactoryBean接口的实现类(ConnectionFactoryBean)，
     * 那么通过id值获取的是这个类(ConnectionFactoryBean)所创建的复杂对象 Connection
     * <p>
     * 若要获取FactoryBean接口的实现类(ConnectionFactoryBean)，那么在通过id值获取时，需要在在这个id前加上&
     * 如 "&conn"
     */
    @Test
    public void test23() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ConnectionFactoryBean conn = (ConnectionFactoryBean) ctx.getBean("&conn");

        System.out.println("conn = " + conn);
    }

    /**
     * 依赖注⼊的体会(DI)
     * <p>
     * 把ConnectionFactoryBean中依赖的4个字符串信息 ，进⾏配置⽂件的注⼊
     * <p>
     * 解耦合
     */
    @Test
    public void test24() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn1 = (Connection) ctx.getBean("conn1");

        System.out.println("conn1 = " + conn1);
    }

    /**
     * 实例工厂 创建 复杂对象
     */
    @Test
    public void test25() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn2 = (Connection) ctx.getBean("conn2");
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回true：只创建一次这种类型的复杂对象
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回false：每一次都创建新的复杂对象
        System.out.println("conn2 = " + conn2);
        System.out.println("conn2 = " + conn2);
    }

    /**
     * 静态工厂 创建 复杂对象
     */
    @Test
    public void test26() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn2 = (Connection) ctx.getBean("staticConnectionFactory");
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回true：只创建一次这种类型的复杂对象
        // 当FactoryBean 接口的实现类 ConnectionFactoryBean的isSingleton()方法返回false：每一次都创建新的复杂对象
        System.out.println("conn2 = " + conn2);
        System.out.println("conn2 = " + conn2);
    }

    /**
     * 输出的快捷键 soutv
     * <p>
     * 测试对象创建的次数，配置文件中scope="singleton"---只创建一次
     * 默认是singleton
     * account = com.spring5.scope.Account@ec756bd
     * account2 = com.spring5.scope.Account@ec756bd
     */
    @Test
    public void test27() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) ctx.getBean("account1");
        Account account2 = (Account) ctx.getBean("account1");

        System.out.println("account = " + account);
        System.out.println("account2 = " + account2);
    }

    /**
     * 输出的快捷键 soutv
     * <p>
     * 测试对象创建的次数，配置文件中scope="prototype"---每次调用都创建一个新的对象
     * <p>
     * <p>
     * account = com.spring5.scope.Account@ec756bd
     * account2 = com.spring5.scope.Account@3c72f59f
     */
    @Test
    public void test28() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) ctx.getBean("account2");
        Account account2 = (Account) ctx.getBean("account2");

        System.out.println("account = " + account);
        System.out.println("account2 = " + account2);
    }

    /**
     * 测试对象创建
     * <p>
     * 当对象是scope="singleton" 时，spring工厂创建的时候，对象就创建了
     * <p>
     * Product对象的创建：
     * Product.Product:测试scope="singleton"
     */
    @Test
    public void test29() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 测试对象创建
     * <p>
     * 当对象是scope="prototype" 时，对象是在获取时创建,即：ctx.getBean()的时候
     * <p>
     * Product对象的创建：
     * Product2.Product2：测试scope="prototype"
     */
    @Test
    public void test30() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product2 product2 = (Product2) ctx.getBean("product2");
    }

    /**
     * 当scope="singleton"时，我们还想让 对象的创建在获取对象的时候发生，
     * 即在ctx.getBean()的时候创建对象，则需要在配置文件中添加 lazy-init="true"，默认是false
     * 即：懒加载
     * Product.Product:测试scope="singleton"
     */
    @Test
    public void test31() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product1 = (Product) ctx.getBean("product1");
    }

    /**
     * spring 生命周期中的初始化需要注意2点：
     * 1.我们开发人员提供初始化方法，
     * 2.Spring调用初始化方法
     * <p>
     * spring 生命周期中的初始化:
     * 第一种方式：实现Spring提供的InitializingBean接口,实现afterPropertiesSet()方法
     * <p>
     * Product.Product:测试scope="singleton"
     * Product.afterPropertiesSet
     */
    @Test
    public void test32() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * spring 生命周期中的初始化需要注意2点：
     * 1.我们开发人员提供初始化方法，
     * 2.Spring调用初始化方法
     * <p>
     * spring 生命周期中的初始化:
     * 第二种方式：直接写一个初始化方法：public void myInit(){}
     * 然后在bean中添加 init-method="myInit"
     * <p>
     * Product2.Product2：测试scope="prototype"
     * Product2.myInit
     */
    @Test
    public void test33() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * spring 生命周期中的初始化需要注意2点：
     * 1.我们开发人员提供初始化方法，
     * 2.Spring调用初始化方法
     * <p>
     * 初始化操作的细节化分析:
     * 1.同时实现了InitializingBean的初始化方法 和 自己的初始化方法myInit的执行顺序:
     * (1). InitializingBean的afterPropertiesSet
     * (2). 普通初始化⽅法
     * <p>
     * 2. 当对象中有注入操作时，注入操作与初始化的先后顺序：
     * 先注入后初始化---afterPropertiesSet看这个方法名也知道是先注入后初始化
     * <p>
     * Product.Product:测试scope="singleton"
     * Product.setName: zhangsan
     * Product.afterPropertiesSetProduct{name='zhangsan'}
     * Product2.myInitProduct{name='zhangsan'}
     */
    @Test
    public void test34() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 销毁方法的操作只适用于scope="singleton"
     * <p>
     * spring 生命周期中的销毁需要注意2点：
     * 1.我们开发人员提供销毁方法，
     * 2.Spring调用销毁方法
     * 这两点跟初始化的时候需要注意的相同。
     * <p>
     * 生命周期的对象的销毁：注意2点：1.在关闭spring工厂的时候，ctx.close()销毁对象。2.Spring调用销毁方法
     * <p>
     * 需要注意的细节与初始化类似，先后顺序是 先Spring提供的接口DisposableBean的方法destroy() 后自己定义的销毁方法 myDestroy()
     * <p>
     * Product.Product:测试scope="singleton"
     * Product.setName: lisi
     * Product.afterPropertiesSetProduct{name='lisi'}
     * Product2.myInitProduct{name='lisi'}
     * 2020-07-05 17:06:51 DEBUG ClassPathXmlApplicationContext:987 - Closing org.springframework.context.support.ClassPathXmlApplicationContext@1fbc7afb, started on Sun Jul 05 17:06:49 CST 2020
     * Product.destroy:Product{name='lisi'}
     * Product2.myDestroyProduct{name='lisi'}
     * <p>
     * Product.destroy:Product{name='zhangsan'}
     * Product.destroy:Product{name='null'}
     * Product.destroy:Product{name='null'}
     * 这三次调用接口的销毁是bean 的 product6,product4,product1 的对象
     */
    @Test
    public void test35() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product produce7 = (Product) ctx.getBean("product7");
        // 关闭spring工厂的时候，ctx.close()销毁对象
        ctx.close();
    }

    /**
     * 配置文件参数化
     * ctx.getBean("conn1").castvar 快捷补全代码
     * soutv 快捷补全输出
     * soutm 快捷补全输出
     * <p>
     * conn1 = com.mysql.jdbc.JDBC4Connection@3b2cf7ab
     * SpringTest.test36
     */
    @Test
    public void test36() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Connection conn1 = (Connection) ctx.getBean("conn1");
        // soutv
        System.out.println("conn1 = " + conn1);
        // soutm
        System.out.println("SpringTest.test36");
    }

    /**
     * 测试自定义类型转换器
     * <p>
     * 实现Spring的Converter接口
     * <p>
     * 其实Spring内置了date的类型转换器，但是日期的格式必须是 2020/05/02种类型，不支持2020-05-02
     * <p>
     * person = Person{name='张三', birthday=Tue Feb 04 00:00:00 CST 2014}
     */
    @Test
    public void test37() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        com.spring5.converter.Person person = (com.spring5.converter.Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * 测试后置bean处理对象
     *
     * category = Category{id=123, name='lisi'}
     */
    @Test
    public void test38() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println("category = " + category);
    }


}
