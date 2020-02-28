package com.jvm_lecture.classloader;
/*
   位置1：输出1,1；位置2：输出1，0
   准备阶段的重要意义
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:" + Singleton.counter1);
        System.out.println("counter2:" + Singleton.counter2);
    }
}

class Singleton{
    public static  int counter1;
    //声明位置1
//   public static int   counter2 = 0;

    private static Singleton singleton = new Singleton();//类的连接的准备阶段位null

    private Singleton() {
        counter1++;
        counter2++;//声明位置2时，counter2只有类的连接的准备阶段默认值为0，此处+1，还未初始化
        System.out.println(counter1);
        System.out.println(counter2);
    }
    //声明位置2
    //初始化过程顺序从上到下，先执行构造器，再初始化counter2,即counter2的值被在此处0覆盖
    public static int   counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
