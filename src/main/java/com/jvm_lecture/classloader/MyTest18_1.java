package com.jvm_lecture.classloader;

public class MyTest18_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        Class<?> clazz = loader1.loadClass("com.jvm_lecture.classloader.MyTest1");
        //com.jvm_lecture.classloader.MyTest1放到C:\ProgramTools\Java\jdk1.8.0_241\jre\classes则会输出null即由根类加载器加载
        System.out.println("class: " + clazz.hashCode());
        System.out.println("classloader: " + clazz.getClassLoader());
    }
}
