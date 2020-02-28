package com.jvm_lecture.classloader;

class CL{
    static {
        System.out.println("CL static block");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws Exception{
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz;
        //使用类加载器加载类CL（ClassLoader类的oadClass）不会导致类初始化，不是对类的主动使用
        clazz = loader.loadClass("com.jvm_lecture.classloader.CL");
        System.out.println(clazz);

        System.out.println("------");
        //反射属于对类的主动使用
        clazz = Class.forName("com.jvm_lecture.classloader.CL");
    }
}
