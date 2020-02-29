package com.jvm_lecture.classloader;

public class MyTest18 {
    public static void main(String[] args) {
        //三种类加载器对应的加载文件目录
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
