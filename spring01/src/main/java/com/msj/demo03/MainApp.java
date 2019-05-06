package com.msj.demo03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class MainApp {
    public static void main(String[] args) {
       //生成工厂对象
        String path = "D:\\code\\javaDemo\\spring01\\src\\main\\resources\\spring03.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.getMessage();
    }
}
