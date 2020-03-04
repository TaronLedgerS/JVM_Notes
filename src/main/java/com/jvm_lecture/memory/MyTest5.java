package com.jvm_lecture.memory;
/*
    jmap
    jcmd pid VM.flags：列出JVM启动参数信息
    jcmd pid help：列出当前运行JAVA进程可执行的操作
    jcmd pid help JFR.dump：查看具体命令选项
    jcmd pid PerfCounter.print：查看JVM性能的参数
    jcmd pid VM.uptime：查看JVM启动时长
    jcmd pid GC.class_histogram:查看系统中类的统计信息
    jcmd pid Thread.print:查看线程堆栈信息
    jcmd pid GC.heap_dump filename:生成转储文件heap dump文件，可用jvisualvm查看
    jcmd pid VM.system_properties:查看JVM的属性信息

    jstack pid：查看或者导出java进程的堆栈信息
    jfr：JAVA Flight Recorder 飞行记录器

 */
public class MyTest5 {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("helloworld");
        }
    }
}
