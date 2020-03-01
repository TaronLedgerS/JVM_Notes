package com.jvm_lecture.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;

//自定义加载类
public class MyTest16 extends ClassLoader {
    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    //设置为系统类加载器必须提供的构造方法
    public MyTest16(ClassLoader parent) {
        super(parent);
    }
    public MyTest16(String classLoaderName){
        super();//默认该类父加载器为系统类加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显示指定父亲类加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    //需要重写，findClass方法会被loadclass方法所调用
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoked:" + className);
        System.out.println("class loader name:" + this.classLoaderName);

        byte[] data = this.loadClassData(className);
        //阅读源码
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className) {
        byte[] data = null;
        className = className.replace(".", "/");

        try(InputStream is = new FileInputStream(new File(this.path+ className + this.fileExtension));
            ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    public static void main(String[] args) throws Exception {
        //对于MyTest1
        //System.out.println(o);com.jvm_lecture.classloader.MyTest1@15db9742(数字为对象的哈希值)
        //System.out.println(o.getClass().getClassLoader());输出了系统类加载器，而不是loader1
        //运行后不会输出findClass的两行字
        //对与MyTest111，由不同加载器加载，产生命名空间不同，所以这里MyTest111是两个不同的标识（hashCode）
        MyTest16 loader1 = new MyTest16("loader1");
        //loader1.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\jvm_lecture\\build\\classes\\");
        loader1.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        Class<?> clazz = loader1.loadClass("com.jvm_lecture.classloader.MyTest111");//试试MyTest1
        System.out.println("class:"+clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println(o);
        System.out.println("----------");

        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        Class<?> clazz2 = loader2.loadClass("com.jvm_lecture.classloader.MyTest111");//试试MyTest1
        System.out.println("class:"+clazz2.hashCode());
        Object o2= clazz2.newInstance();
        System.out.println(o2);
        System.out.println("----------");
        //令loader1做loader3的父加载器，由于命名空间，不会执行findclass
        MyTest16 loader3 = new MyTest16(loader1,"loader3");
        loader3.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        Class<?> clazz3 = loader3.loadClass("com.jvm_lecture.classloader.MyTest111");
        System.out.println("class:"+clazz3.hashCode());
        Object o3= clazz3.newInstance();
        System.out.println(o3);
        System.out.println("----------");

        MyTest16 loader4 = new MyTest16(loader3,"loader4");
        loader4.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        Class<?> clazz4 = loader4.loadClass("com.jvm_lecture.classloader.MyTest111");
        System.out.println("class:"+clazz4.hashCode());
        Object o4= clazz4.newInstance();
        System.out.println(o4);
        System.out.println("----------");

        //类的卸载：需要Class对象不在被触及
        loader2 = null;
        clazz2 = null;
        o2 = null;
        System.gc();//显式调用垃圾回收
        //Thread.sleep(40000);
        //jvm参数 -XX:+TraceClassUnloading 可以看到被卸载
        loader2 = new MyTest16("loader1");
        loader2.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        clazz2 = loader2.loadClass("com.jvm_lecture.classloader.MyTest111");
        System.out.println("class:"+clazz2.hashCode());
        o2 = clazz2.newInstance();
        System.out.println(o2);
        System.out.println("----------");

    }


}
