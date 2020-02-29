package com.jvm_lecture.classloader;

import java.lang.reflect.Method;

/*
    把MyPerson.class删掉→Myperon分别由loader1、loader2从指定目录下加载MyPerson.class→导致两个MyPerson的命名空间不同，
    所以clazz1 == clazz2返回false， method.invoke(o1, o2);出现异常，因为已经不是同一种类相互不可见。
 */

/*
    类加载器的双亲委托模型与命名空间的好处
    1. 可以确保Java核心库的类型安全；所有Java应用至少会引用java.lang.Object类，即在运行期java.lang.Object会被加载到jvm中
    如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能就会在JVM中存在多个版本的java.lang.Objectl类，而且这些类之间
    还是不兼容的，相互不可见的（正是命名空间在发挥着作用）
    借助于双亲委托机制，JAVA核心类库中的类的加载工作都是有根类加载类同一完成，从而确保了JAva应用所使用的都是同一个版本的JAVA
    核心类库，他们之间是相互兼容的
    2. 可以确保JAVA核心类库所提供的类不会被自定义的类所替代
    3. 不同的类加载器可以为相同名称（binary name） 的类创建额外的命名空间，相同名称的类可以并存在Java虚拟几种，只需要用
    不同的类加载器来加载他们即可。不同类加载器所加载器的类之间是不兼容的，这就相当于在JAVA虚拟机内部创建了一个有一个相互
    隔离的JAVA类空间，这类技术在很多框架中都得到了实际应用
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");
        loader2.setPath("C:\\Users\\sky\\Dropbox\\MyNote\\Java\\JavaVirtualMachine\\");

        Class<?> clazz1 = loader1.loadClass("com.jvm_lecture.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.jvm_lecture.classloader.MyPerson");
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1.equals(clazz2));

        Object o1 = clazz1.newInstance();
        Object o2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(o1, o2);//第一个是调用发起对象，第二个是参数

    }
}
