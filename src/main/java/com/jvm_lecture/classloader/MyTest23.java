package com.jvm_lecture.classloader;


import sun.misc.Launcher;

/*
    1. 在运行期一个java类是由该类的完全限定名（binary name 二进制名）和用于加载该类的定义加载器（defining loader）
    所共同决定的。如果同样名字的类是由不同的两个加载器所加载，这些类是不同的，即使字节码完全相同，位置也相同，

    2.修改根类加载器的加载目录java -Dsun.boot.class.path=.\ com.jvm_lecture.classloader.MyTest23
      在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下信息
        Error occurred during initialization of VM
        java/lang/NoClassDefFoundError: java/lang/Object
 */
public class MyTest23 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        /*
            当JVM启动时，一块特殊的机器码会运行，他会加载扩展类加载器与系统类加载器，这个特殊的机器码叫做启动类加载器（Bootstrap）
            内建于jvm的根类加载器（由C++编写）会加载java.lang.ClassLoader以及其它的Java平台类
            启动类加载器并非JAVA类，而其它加载器则是实现为JAVA类
            启动类加载器是特定与平台的机器指令，他负责开启整个加载过程
            启动类加载器还会负责加载供JRE正常运行所需的基本组件，如java.util与java.lang包中的类

         */

        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());
        //系统类加载器这个属性值:默认为null，
        //则表示ClassLoader.getSystemClassLoader()默认为AppClassLoader
        System.out.println(System.getProperty("java.system.class.loader"));
        /*
        修改默认的系统类加载器并运行
        java -Djava.system.class.loader=com.jvm_lecture.classloader.MyTest16 com.jvm_l
ecture.classloader.MyTest23
         */
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
