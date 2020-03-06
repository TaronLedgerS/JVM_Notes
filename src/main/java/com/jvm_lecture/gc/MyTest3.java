package com.jvm_lecture.gc;
/*
-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8
-XX:MaxTenuringThreshold=5
-XX:+PrintTenuringDistribution
-XX:PretenureSizeThreshold=5242880 -XX:+UseSerialGC

MaxTenuringThreshold作用：在可以自动调节对象晋升（Promote）到老年代的阈值GC次数（0~5次都可能）中，设置该阈值的最大值
该参数的默认值为15，GC15次仍没回收则保证进入老年代
在JVM中，该数值由4个bit来表示，最大为1111，即15，CMS默认为6，G1默认为15

PrintTenuringDistribution：输出每个年龄的空间占用大小

经历了多次GC后，存活的对象会在From Survivor与To Survivor之间来回存放，而这里面的一个前提这是这两个空间有足够的大小来存放这些数据
在GC算法中会计算每个对象年龄大小，如果达到某个年龄后发现，总大小已经大于Survivor空间的50%，那么这时就需要调整阈值，
不能再等到默认的15次GC后才完成晋升，因为这样会导致Survivor空间不足，
所以需要调整阈值，让这些存活对象尽快晋升

 */


public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[2 * size];//2M的大小
        byte[] myAlloc2 = new byte[2 * size];//2M的大小
        byte[] myAlloc3 = new byte[2 * size];//2M的大小
        byte[] myAlloc4 = new byte[2 * size];//2M的大小
    }
}
