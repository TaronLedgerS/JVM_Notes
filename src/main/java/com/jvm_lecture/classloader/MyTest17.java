package com.jvm_lecture.classloader;

public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.jvm_lecture.classloader.MySample");

        System.out.println("class: " + clazz.hashCode());
        //如果注释掉该行，则不实例化MySample对象，即MySample构造方法不会被调用，因此不会实例化MyCat
        //即没有对MyCat主动使用
        Object object = clazz.newInstance();

    }
}
