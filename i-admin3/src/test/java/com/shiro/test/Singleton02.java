package com.shiro.test;

/**
 * Created by 郑文旭 on 2020/3/9.
 * 懒汉式  单例模式
 */
public class Singleton02 {
    private static Singleton02 instance = null;
    private Singleton02(){}

    public static synchronized Singleton02 getInstance(){
        if (instance==null)
        instance = new Singleton02();
        return instance;
    }

    public int[] Sort(int [] arr){
        for(int i = 1;i<arr.length;i++){
            for(int j =0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Singleton02 s1 = Singleton02.getInstance();
        System.out.println(s1);
        Singleton02 s2 = Singleton02.getInstance();
        System.out.println(s2);

        Singleton02 s3 =new Singleton02();
        int b[]={1,-1,3,4,4,7,6,5};
        System.out.println(s3.Sort(b)[7]);
    }
}
