package com.jvm_lecture.classloader;

/*
    当前类加载器（Current Classloader）
    每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（指的是所以来的类）
    如果ClassX引用了ClassY，那么如果ClassY尚未加载，则会用ClassX的类加载器去加载ClassY

    线程上下文类加载器（Context Classloader）:
    JDK1.2引入，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
    分别用来设置上下文类加载器
    如果没有通过setContextClassLoader(ClassLoader cl)进行设置，那么线程将继承其父线程的上下文类加载器
    Java应用运用时的初始线程上下文类加载器。在线程中运行中的代码可以通过该类加载器来加载类与资源

    线程上下文类加载器的重要性：

    SPI（Service Provider Interface） 如JDBC，一般是放在ClassPath
    父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类
    这样就改变了父ClassLoader不能使用子ClassLoader或者其它没有直接斧子关系的ClassLoader加载的类的情况，
    即改变了双亲委托模型

    线程上下文类加载器，就是当前线程的Current Classloader

    ★在双亲委托模型下，类加载是由上而下的，即下层的类加载器会委托上层进行加载。但对于SPI来说，有些接口是Java核心库所提供的
    而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自于不同的jar包，Java的启动类加载是不会加载其它来源的
    jar包，这样传统的双亲委托模型是无法满足SPI的要求，而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器
    来实现对于接口实现类的加载

    JDBC的例子：
     //驱动的实现jar包一般放在classPath，由应用类加载器加载
     class.forName("com.mysql.driver.Driver");
     //connection是接口，Driver里包含具体实现，如Oracle厂商
     Connection conn = Driver.getConnection();
     Statement st = conn.getStatement();

 */
public class MyTest24 {
    public static void main(String[] args) {
        //sun.misc.Launcher$AppClassLoader@73d16e93
        System.out.println(Thread.currentThread().getContextClassLoader());
        //Thread处于核心java包所以是null
        System.out.println(Thread.class.getClassLoader());
    }
}
