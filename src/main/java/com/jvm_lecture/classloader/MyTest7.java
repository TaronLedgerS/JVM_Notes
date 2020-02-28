package com.jvm_lecture.classloader;
/*



*/
public class MyTest7 {
    public static void main(String[] args)throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        //返回null则表示为根类加载器，原生类型或者void返回null，String在java.lang.*
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.jvm_lecture.classloader.B");
        //sun.misc.Launcher$AppClassLoader@73d16e93 系统类加载器，工程当中的classPath
        System.out.println(clazz2.getClassLoader());
    }
}

class B{

}