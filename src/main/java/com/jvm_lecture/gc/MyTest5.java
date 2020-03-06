package com.jvm_lecture.gc;

/*
-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=8
 */
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[4 * size];//2M的大小
        System.out.println("-----1--------");
        byte[] myAlloc2 = new byte[4* size];//2M的大小
        System.out.println("-----2--------");
        byte[] myAlloc3 = new byte[4 * size];//2M的大小
        System.out.println("-----3--------");
        //当新生代装不下4的时候，直接在老年代生成对象
        byte[] myAlloc4 = new byte[2 * size];//2M的大小
        System.out.println("-----4--------");



    }
}
