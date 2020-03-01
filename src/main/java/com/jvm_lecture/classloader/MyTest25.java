package com.jvm_lecture.classloader;

public class MyTest25 implements Runnable {
    private Thread thread;

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        //this.thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new MyTest25();
    }

}
