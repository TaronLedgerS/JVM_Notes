package com.jvm_lecture.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //把动态生成的代理类的字节码，到当前目录
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //被代理对象
        RealSubject rs = new RealSubject();
        //动态代理，并设置被代理对象
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> clazz = rs.getClass();

        //指定被代理对象的类加载器，被代理对象的实现的接口，以及动态代理类，返回生成的实现被代理对象的接口的代理类对象
        Subject subject = (Subject) Proxy.
                newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ds);
        //代理对象的重写方法request
        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
        //代理对象的重写方法toString()
        System.out.println(subject.toString());
    }
}
