package com.jvm_lecture.classloader;
/*
 修改扩展类加载器所寻找的路径：
   jar cvf test.jar com\jvm_lecture\classloader\MyTest1.class
   java -Djava.ext.dirs=.\ com.jvm_lecture.classloader.MyTest22
   则MyTest1由扩展类加载器加载
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }
    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }
}
