package com.jvm_lecture.classloader;

import java.lang.reflect.Method;

public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz1 = loader1.loadClass("com.jvm_lecture.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.jvm_lecture.classloader.MyPerson");
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1.equals(clazz2));

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1, o2);//第一个是调用发起对象，第二个是参数

    }
}
