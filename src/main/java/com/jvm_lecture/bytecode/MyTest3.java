package com.jvm_lecture.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/*
  对于java类的每一个实例方法（非static方法），其在编译后生成的字节码中，方法参数的数量总会比源代码的方法参数
  数量多一个（this），他位于方法的第一个参数位置出；这样我们就可以在java实例方法中使用this来去访问当前对象的
  属性以及其它方法。

  这个操作是在编译期间完成的，即javac编译器在编译时将对this的访问转化为对一个普通实例方法参数的访问，接下来
  运行期间，由jvm在调用实例方法时，自动向实例方法传入this参数，所以，在实例方法的局部变量表中，至少会有一个
  指向当前对象的局部变量。
 */

/*
Java字节码对于异常的处理方式：
1.同一采用一场表的方式来对异常进行处理
2.在jdk1.4.2之前的版本中，并不是使用异常表的方式来对一场表进行处理的，而是采用特定的指令方式
3.当异常处理存在finally语句块，现代化的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch快后面
换句话说，程序中存在多少个catch块，就会在每个catch块后面重复多少个finally语句块的字节码



 */
public class MyTest3 {
    public void test() throws IOException,FileNotFoundException,NullPointerException{
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (Exception ex) {

        } finally {
            System.out.println("finally");
        }
    }
}
