package com.hangjiang.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by jianghang on 2017/7/24.
 */
public class StringUtil {

    public static final String SEPARATOR = String.valueOf((char)29);

    public static boolean isEmty(String str){
        if(str != null){
            str = str.trim();
        }

        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmty(str);
    }

    public static String[] splitString(String str,String separator){
        return StringUtils.splitByWholeSeparator(str,separator);
    }

    public static void main(String[] args){
        Runnable r = () -> System.out.println("hello");
        new Thread(r).start();
    }
}
