package com.jvm_lecture.memory;
/*
  虚拟机栈溢出：递归
 */

public class MyTest2 {
    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            Thread.sleep(50000);
            myTest2.test();
        } catch (Throwable ex) {//StackOverflowError→VirtualMachineError→Error→Throwable
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }

    }
}
