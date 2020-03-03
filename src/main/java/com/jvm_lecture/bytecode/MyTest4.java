package com.jvm_lecture.bytecode;

/*
    调用栈的元素是栈帧
    栈帧（stack frame）
    栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。
    栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、
方法的返回地址以及操作数栈等信息。


    符号引用，直接引用
    符号引用：类的全限定名
    直接引用：内存地址

    有些符号引用，在类加载阶段或者是第一次使用时，就会转换为符号引用，成为静态解析
    1.静态方法 2.父类方法 3.构造方法 4.私有方法（不会被覆盖）----非虚方法
    有些符号引用，则在每次运行期转换为直接引用，成为动态链接，这体现为Java的多态性

    invokevirtual字节码助记符
    Animal a = new Cat();
    a.sleep();
    a = new Dog();
    a.sleep();
    a = newTiger();
    a.sleep()

 */

/*
指令
   1. invokeinterface: 调用接口中的方法，实际上是运行期决定的，决定到底调用实现该接口的那个对象的特定方法
   2. invokestatic：调用静态方法
   3. invokespecial：调用自己的私有方法，构造方法<init>以及父类的方法
   4. invokevirtual：调用虚方法（C++有这个概念，java没有，但字节码有，多态的体现），运行期动态查找的过程
   5. invokedynamic：动态调用方法（了解）
 */


public class MyTest4 {
    //了解：slot是存储局部变量表的基本单位，可能存在复用的情况，可能有3~5个slot
//    public void test() {
//        int a = 3;
//        if (a < 3) {
//            int b = 4;
//            int c = 5;
//        }
//        int d = 7;
//        int e = 8;
//    }


    public static void test(){
        System.out.println("test invoked");

    }

    public static void main(String[] args) {
        test();
    }

}
