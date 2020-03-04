package com.jvm_lecture.memory;

import java.util.ArrayList;
import java.util.List;

/*
  虚拟机栈：线程私有，以Stack Frame 栈帧为单位数据结构；八种基本类型引用类型变量是存在局部变量表中，即在虚拟机栈中
  程序计数器（Program Counter）：每个线程私有的一个小内存空间，字节码解释器工作时通过PC来选下一条执行的字节码指令
  本地方法栈：主要用于本地（native）方法
  ★堆（Heap）：JVM管理内存最大的一块区域，为所有线程共享，虚拟机启动时创建，用于存放对象实例以及数组。
  方法区（Method Area）：存储元信息或类型信息。永久代（Permanent Generation，1.8后废弃），使用元空间替代（meta space）
  运行时常量池：方法区的一部分内容。编译期确定的
  直接内存（Direct Memory）：不是JVM管理的内存区域，由操作系统管辖，但JVM向其申请引用。

  局部变量表中的引用变量会指向堆中的实例对象数据以及方法区中该对象的元数据（如class对象）
    指向方式1：引用变量指向指针（两个指针），指针指向实例对象与指针指向元数据
         缺点：指针会随着垃圾回收的堆上对象移动（内存压缩）而频繁改变（第一个指针）
    （Oracle的Hotspot）指向方式2：引用变量指向实例数据与指针，该指针指向元数据

    设置内存限制
    添加虚拟机参数：-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError


 */
public class MyTest1 {
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();

        for (; ; ) {
            list.add(new MyTest1());
            //开发时不建议使用，1.8运行垃圾回收器，尝试回收不再被使用对象，本地方法
            System.gc();
        }
    }
}
