package com.jvm_lecture.gc;
/*
设置直接在老年代分配空间的新生代对象大小阈值：
-XX:PretenureSizeThreshold=5242880
 */
public class MyTest2 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[9* size];//5M的大小


//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}