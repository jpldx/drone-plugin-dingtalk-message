package com.jpldx.drone.plugin.dingtalk.utils;

/**
 * @author jpldx
 */
public class StringUtils {


    public static boolean isBlank(String str){
        return str == null || str.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBlank(""));
    }
}
