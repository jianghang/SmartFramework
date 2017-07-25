package com.hangjiang.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jianghang on 2017/7/25.
 */
public final class ReflectionUtil {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls){
        Object instance = null;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            logger.error("new instance failure",e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            logger.error("new instance failure",e);
            throw new RuntimeException(e);
        }

        return instance;
    }

    public static Object invokeMethod(Object obj, Method method,Object...args){
        Object result = null;
        try {
            method.setAccessible(true);
            result = method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            logger.error("invoke method failure",e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            logger.error("invoke method failure",e);
            throw new RuntimeException(e);
        }

        return result;
    }

    public static void setField(Object obj, Field field,Object value){
        try {
            field.setAccessible(true);
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            logger.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
