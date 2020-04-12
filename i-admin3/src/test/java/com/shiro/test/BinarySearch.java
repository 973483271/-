package com.shiro.test;

import javax.sound.midi.Soundbank;

/**
 * Created by 郑文旭 on 2020/3/10.
 */
public class BinarySearch {

    private int i1;

    /**
     * 循环
     * @param key
     * @param list
     * @return
     */
    public static int binarySearch(int key,int[] list) {
        int low = 0;
        int height = list.length - 1;

        while (low <= height) {
          int  mid = (low + height) >>> 1;

            if (list[mid] < key) {
                 low = mid + 1;
            } else if (list[mid] > key) {
                height = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归
     * @param key
     * @param list
     * @return
     */
    public static int binarySearch2(int key,int[] list,int low,int height) {

        if(low<=height){
            int  mid = (low + height) >>> 1;
            if (list[mid] < key) {
                low = mid + 1;
                binarySearch2(key,list,low,height);
            } else if (list[mid] > key) {
                height = mid - 1;
                binarySearch2(key,list,low,height);
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        System.out.println(binarySearch(4,a));
        System.out.println(binarySearch2(4,a,0,6));
        String str1 ="123";
        String str2= "23";
        final String str3 = "23";
        String str4 = str3+str2;
        System.out.println();
    }
}
