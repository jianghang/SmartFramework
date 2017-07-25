package com.hangjiang.framework.helper;

import com.hangjiang.framework.annotation.Inject;
import com.hangjiang.framework.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * Created by jianghang on 2017/7/25.
 */
public final class IocHelper {

    static {
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtils.isNotEmpty((Collection<?>) beanMap)){
            for (Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    for(Field beanField : beanFields){
                        if(beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
