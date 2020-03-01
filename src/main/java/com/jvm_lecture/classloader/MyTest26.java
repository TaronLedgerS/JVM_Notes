package com.jvm_lecture.classloader;
/*
    线程上下文类加载器的一般使用模式：获取-使用-还原
    //伪代码
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader()
    try{
        Thread.currentThread().setContextClassLoader(targetTccl);
        myMethod();
    }finally{
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程上下文类加载器做一些事情

    如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该以来类之前没有被加载过的话）

    ContextClassLoader的作用就是为了破坏Java的类加载委托机制。

    当高层提供了统一的接口让底层区实现，同事又要在高层加载（或实例化）底层的类时，就必须要通过线程上下文类加载器
    来帮助高层的ClassLoader找到并加载该类。
 */

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest26 {
    public static void main(String[] args) {
        //修改线程上下文加载器为扩展加载器，会导致没办法加载JDBC的驱动类
        //Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());
        //加载Driver.class，同时初始化了里面的HashMap的cache与lazyIterator
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: " + driver.getClass() + ",loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
        System.out.println("");
    }
}
