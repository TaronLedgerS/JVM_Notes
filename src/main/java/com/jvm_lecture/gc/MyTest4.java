package com.jvm_lecture.gc;


/*
-verbose:gc -Xmx200M -Xmn50M -XX:TargetSurvivorRatio=60 -XX:+PrintGCDetails -XX:+PrintTenuringDistribution
-XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:MaxTenuringThreshold=3

//s区超过60%会重新调整阈值，但不会超过MaxTenuringThreshold=5
-XX:TargetSurvivorRatio=60
//分别指定老年代新生代收集器
-XX:+UseConcMarkSweepGC -XX:UseParNewGC
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes1 = new byte[512 * 1024];
        byte[] bytes2 = new byte[512 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        byte[] bytes3 = new byte[1024 * 1024];
        byte[] bytes4 = new byte[1024 * 1024];
        byte[] bytes5 = new byte[1024 * 1024];

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        myGC();
        Thread.sleep(1000);
        System.out.println("--------");

        System.out.println("hello world");
    }

    private static void myGC() {
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024 * 1024];
        }
    }
}
