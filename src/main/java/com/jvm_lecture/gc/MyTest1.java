package com.jvm_lecture.gc;
/*
虚拟机参数：
-verbose:gc 输出垃圾回收日志
-Xms20M 设置堆的最大值
-Xmx20M 设置堆的最小值 设置为一样可以gc后防止内存抖动的问题
-Xmn10M 堆中新生代
-XX:+PrintGCDetails
-XX:SurvivorRatio=8  Eden与survivor的比例为8:1
 */

/*
//[Minor gc(内存分配错误) [Parallel Scavenge垃圾收集器 新生代：回收前对象的占用空间→回收之后（新生代总空间9M）]
[GC (Allocation Failure) [PSYoungGen: 5940K->696K(9216K)]
//GC之前总堆（新老）的已用大小→回收之后已用大小（堆总空间19M）
5940K->5824K(19456K), 0.0022526 secs]
//时间：用户空间，系统空间，实际时间
[Times: user=0.00 sys=0.00, real=0.00 secs]
 */

/*
//full GC（工效学）
[Full GC (Ergonomics)
//新生没了
[PSYoungGen: 696K->0K(9216K)]
//老年代回收并收了一些新生代
[ParOldGen: 5128K->5647K(10240K)]
//堆的变化
5824K->5647K(19456K),
//元空间变化
[Metaspace: 2630K->2630K(1056768K)], 0.0035296 secs]
[Times: user=0.06 sys=0.00, real=0.00 secs]
 */

/*
heap
 PSYoungGen      total 9216K, used 3397K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 8192K, 41% used [0x00000000ff600000,0x00000000ff951740,0x00000000ffe00000)
  from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
  to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 ParOldGen       total 10240K, used 5647K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 55% used [0x00000000fec00000,0x00000000ff183d48,0x00000000ff600000)
 Metaspace       used 2638K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 280K, capacity 386K, committed 512K, reserved 1048576K
 */

public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[2 * size];//2M的大小
        byte[] myAlloc2 = new byte[2* size];//2M的大小
        byte[] myAlloc3 = new byte[3 * size];//2M的大小
        //当新生代装不下4的时候，直接在老年代生成对象
        byte[] myAlloc4 = new byte[5 * size];//2M的大小

        System.out.println("hello world");


    }
}
