package com.shiro.test;

import sun.applet.Main;

import java.time.LocalDateTime;
import java.util.Calendar;

import static java.util.Calendar.*;

/**
 * 字符串倒序输出
 */
public class Test01 {
    /**
     * 字符串倒序输出
     * @param str
     * @return
     */
    public  static  String res(String str){
        if(str==null||str.length()<=1){
            return str;
        }
        return res(str.substring(1))+str.charAt(0);
    }

    /**
     *
     */
    public  static  void Time(){
        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt.getYear());
        System.out.println(lt.getMonth().getValue());
        System.out.println(lt.getDayOfWeek().getValue());

        String s1 = "A";
        String s2 = "B";
        String s3 = "A";
        Integer s4 = 1;
        String s5 = new String("11");
        System.out.println(s1.equals(s3));
        System.out.println(s1.hashCode()+"==="+s3.hashCode());
        System.out.println(System.identityHashCode(s1)+"---"+System.identityHashCode(s3));
    }


    public static void main(String[] args) {
        System.out.println(res("123456789"));
        Time();
    }
}
