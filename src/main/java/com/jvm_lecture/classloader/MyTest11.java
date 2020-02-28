package com.jvm_lecture.classloader;

class Parent3{
    static int a = 3;
    static{
        System.out.println("Parent3 static block");
    }

    static void dosomething() {
        System.out.println("dosomething()");
    }
}
class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}

public class MyTest11 {
    public static void main(String[] args) {
        //均没有对子类Child3进行主动使用
        System.out.println(Child3.a);
        System.out.println("--------");
        Child3.dosomething();
    }
}
