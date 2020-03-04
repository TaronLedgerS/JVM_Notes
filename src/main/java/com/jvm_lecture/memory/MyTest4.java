package com.jvm_lecture.memory;
/*
    方法区产生内存溢出错误：运行期动态生成类

 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class MyTest4 {

    public static void main(String[] args) {
        //不断创建mytest4的子类，然后放到元空间
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
                    proxy.invokeSuper(obj, args1));
            System.out.println("hello world");

            enhancer.create();
        }
    }

}
