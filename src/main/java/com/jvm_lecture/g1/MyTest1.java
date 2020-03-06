package com.jvm_lecture.g1;
/*
JDK1.9默认的垃圾回收器是G1
-verbose:gc -Xms10m -Xmx10m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:MaxGCPauseMillis=200m
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[size];
        System.out.println("-----1--------");
        byte[] myAlloc2 = new byte[size];
        System.out.println("-----2--------");
        byte[] myAlloc3 = new byte[size];
        System.out.println("-----3--------");
        //当新生代装不下4的时候，直接在老年代生成对象
        byte[] myAlloc4 = new byte[size];
        System.out.println("-----4--------");



    }
}
