package com.jvm_lecture.classloader;

/*
* 主动使用的情况：创建类的实例会导致类的初始化
* 所有的java虚拟机必须在每个类或接口被java程序“ **首次主动使用** ”时才初始化他们
* 对于数组实例来说，其类型是有JVM在运行期动态生成的，表示为[Lcom.jvm_lecture.classloader.MyParent4
  动态生成的类型的父类是Object
* 对于数组来说，JavaDoc经常将构成数组的元素称为Componet，实际上就是将数组降低一个维度后的类型
* 助记符：
*   anewarray:表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
*   newarray:表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引值压入栈顶
* */
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("=========");
//        MyParent4 myParent5 = new MyParent4();
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());
        System.out.println("=========");
        int[] ints = new int[1];
        System.out.println(ints.getClass().getSuperclass());
        System.out.println(ints.getClass());
        char[] chars = new char[1];
        System.out.println(chars.getClass());
        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());
        short[] shorts = new short[1];
        System.out.println(shorts.getClass());
        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

    }
}
class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
