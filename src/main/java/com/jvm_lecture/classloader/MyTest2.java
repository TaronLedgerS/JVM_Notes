package com.jvm_lecture.classloader;

/*
* 常量在编译阶段，会存入到调用这个常量的方法所在的类（MyTest2）的常量池中
* 本质上，调用类，并没有直接引用到定义常量的类，因此并不会触发
* 定义常量的类（MyParent2）的初始化
* 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
* 甚至，我们可以将MyParent2的class文件删除
* 助记符：都存在对应的类进行操纵
* ldc表示将int，float 或String类型的常量只从常量池中推送至栈顶
* iconst_1表示将int类型1推送至栈顶（iconst_m1、iconst_0~iconst_5）
* bipush表示将单字节(-128~127)的常量值推送至栈顶
* sipush表示将短整型常量值（-32768~32767）推送至栈顶
* */

public class MyTest2 {
    public static void main(String[] args) {
        //System.out.println(MyParent2.str);//ldc
        //System.out.println(MyParent2.s);//bipush
        //System.out.println(MyParent2.i);//sipush
//        System.out.println(MyParent2.m);//iconst_1
        System.out.println(MyParent2.j);//bipush
    }
}
class MyParent2{
    public static final String str = "MyParent2 static string";
    public static final short s = 127;
    public static final int i = 128;
    public static final int m = 1;
    public static final int j = -1;
    static {
        System.out.println("MyParent2 static block");
    }
}
