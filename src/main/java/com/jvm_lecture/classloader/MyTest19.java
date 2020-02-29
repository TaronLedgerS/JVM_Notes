package com.jvm_lecture.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {
    public static void main(String[] args) {
        //扩展目录下的class文件
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println((aesKeyGenerator.getClass().getClassLoader()));
        System.out.println(MyTest19.class.getClassLoader());
    }
}
