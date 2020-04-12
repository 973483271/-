package com.shiro.test;

/**
 * Created by 郑文旭 on 2020/3/9.
 * 饿汉式 单例模式
 */
public class Singleton01 {
    private Singleton01(){}  //构造器
    private static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance(){
        return  instance;
    }

    public static void main(String[] args) {
        Singleton01 s1 = Singleton01.getInstance();
        System.out.println(s1);
        Singleton01 s2 = Singleton01.getInstance();
        System.out.println(s2);
    }
}
