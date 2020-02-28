package com.jvm_lecture.classloader;

/*
* 1.对于静态字段来说，只有直接定义了该字段的类才会被初始化
* 2.一个类在初始化时，要求其父类全部都已经初始化完毕
* 虚拟机参数 -XX：+TraceClassLoading，用于追踪类的加载信息并打印出来
* -XX:+<option>，表示开启option选项
  -XX:-<option>，表示关闭option选项
  -XX:<option>=<value>，表示将option选项的值设置位value
* */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);//1
        //System.out.println(MyChild1.str2);//2
    }
}

class MyParent1{
    public static String str = "MyParent1 static string";
    static {
        System.out.println("1.MyParent1 static block ");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "MyChild1 static string";
    static{
        System.out.println("2.MyChild1 static block");
    }
}