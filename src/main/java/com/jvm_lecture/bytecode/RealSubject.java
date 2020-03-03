package com.jvm_lecture.bytecode;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("from realsubject");
    }
}
