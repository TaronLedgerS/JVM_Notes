package com.jvm_lecture.bytecode;

public class MyTest2 {
    String str = "welcome";
    private  int x = 5;

    public static Integer in = 10;

    public synchronized void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }
    //private  Object object;
    private void test(String str) {
        synchronized (str) {//对传进来的对象进行上锁
            System.out.println("hello world");
        }
    }

    private synchronized static void test2() {

    }
    static {
        System.out.println("test");
    }
}
