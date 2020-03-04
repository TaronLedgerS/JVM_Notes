package com.jvm_lecture.memory;
/*
    死锁
 */
public class MyTest3 {
    public static void main(String[] args) {
        //构造函数第一个参数是函数式接口Runnable的实现()->A.method，第二个参数是线程名字
        new Thread( ()->A.method(),"Thread-A" ).start();
        new Thread( ()->B.method(),"Thread-B" ).start();

        try {
            Thread.sleep(400000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A{
    public static synchronized void method() {//持有的是ClassA的锁
        System.out.println("method from A");
        try {
            Thread.sleep(8000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class B{
    public static synchronized void method() {
        System.out.println("method from B");

        try {
            Thread.sleep(8000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}