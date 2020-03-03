package com.jvm_lecture.bytecode;

/*
   方法的动态分派
   涉及方法接收者与字节码指令invokevirtual字节码指令的多态查找流程





 */
public class MyTest6 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        apple.test();
        orange.test();
        apple = new Orange();
        apple.test();
    }
}
class Fruit{
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}