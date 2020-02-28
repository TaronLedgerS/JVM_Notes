package com.jvm_lecture.classloader;

import java.util.UUID;
/*
* 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中
* 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
* */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}
class MyParent3{
    //随机生成的32位长度的常量值，但是在编译期间并不知道UUID是多少，不是编译期常量
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static code");
    }
}
