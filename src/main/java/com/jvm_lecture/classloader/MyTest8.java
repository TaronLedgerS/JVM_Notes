package com.jvm_lecture.classloader;

import java.util.Random;
/*
javap -c com.jvm_lecture.classloader.MyTest8
会产生助记符iconst_3、getstatic等
 */
class FinalTest{
    public static final int x = 3;
    public static final int z = new Random().nextInt(3);
    public static int y = 3;
    static {
        System.out.println("FinalTest static block");
    }
}

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);//不需要初始化FinalTest，将x放到常量池中
        System.out.println("-------");
        System.out.println(FinalTest.z);//运行期才能确定z的值，y同理，都会使该类初始化，但只会初始化一次
        System.out.println(FinalTest.y);
    }
}

