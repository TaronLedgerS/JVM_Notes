package com.jvm_lecture.classloader;
//虽然数组的getClass().getClassLoader()获取的类加载器与元素一致，但是数组是由虚拟机在运行时动态加载的，而不是类加载器加载的

public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        strings[0] = "11";
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("-----");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("----");
        int[] ints = new int[2];
        ints[0]= 1;
        System.out.println(ints.getClass().getClassLoader());//输出的null与String输出的null含义不一样。表示无加载器
    }
}
