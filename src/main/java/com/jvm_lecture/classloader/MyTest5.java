package com.jvm_lecture.classloader;

import java.util.Random;

/*
    1.当一个类被初始化时，他实现的接口不会被初始化
    2.当一个接口被初始化时，他实现的接口不会被初始化
    3.只有在真正是使用到父接口时（如引用接口中所定义的常时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        new C();
        new C();
        System.out.println(MyChild5.b);//1
        //System.out.println(MyParent5_1.thread);//2
        System.out.println(MyGrandpa5_1.thread);//3
    }
}

interface MyGrandpa5{
    //接口中的字段都是默认static、public、final。不能有静态初始化代码块
//    public static final int a = 5;

    //如果MyParent5被初始化了，那这个对象会被创建，代码块会被执行
    public static final Thread thread = new Thread(){//匿名类
        //此处不能定义构造方法
        //实例化代码块
        {
            System.out.println("MyGrandpa5 invoke");
        }
    };
}

class MyParent5 implements MyGrandpa5 {
    public static Thread thread = new Thread(){//匿名类
        {
            System.out.println("MyParent5 invoke");
        }
    };
}

class MyChild5 extends  MyParent5 {
    public static int b = 6;//
    //public static final int c = new Random().nextInt(2);
}


class C{
    //与静态代码块不一样，每一个C的实例时，这个代码块都会被执行，且比构造方法先执行
    {
        System.out.println("Hello");
    }
    public C() {
        System.out.println("c");
    }
}

interface MyGrandpa5_1{
    public static Thread thread = new Thread(){//匿名类
        {
            System.out.println("MyGrandpa5_1 invoke");
        }
    };
}
interface MyParent5_1{
    public static Thread thread = new Thread(){//匿名类
        {
            System.out.println("MyParent5_1 invoke");
        }
    };
}

