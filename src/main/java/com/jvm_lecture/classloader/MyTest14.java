package com.jvm_lecture.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        //用线程的方式获取类加载器，获取当前线程上下文加载器(来自于创建此线程的父线程，默认与父线程一致)
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        //获取资源数据
        String resourceName = "com/jvm_lecture/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("--------");
        Class<?> clazz;
        clazz= MyTest14.class;
        System.out.println(clazz.getClassLoader());
        clazz = String.class;
        System.out.println(clazz.getClassLoader());
    }
}
