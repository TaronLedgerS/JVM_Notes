package com.jvm_lecture.classloader;

/*
    关于命名空间的重要说明
    1.子加载器所加载的类能够访问父加载器所加载的类
    2.父加载器所加载的类无法访问子加载器所加载的类
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        //删除MyCat.class，加载MySample会报错
        //删除MySample.class，加载MySample不会报错，mySample由loader1加载，但是MyCat是系统类加载器加载
        Class<?> clazz = loader1.loadClass("com.jvm_lecture.classloader.MySample");

        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
