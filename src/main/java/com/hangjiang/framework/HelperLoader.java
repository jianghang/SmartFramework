package com.hangjiang.framework;

import com.hangjiang.framework.helper.BeanHelper;
import com.hangjiang.framework.helper.ClassHelper;
import com.hangjiang.framework.helper.ControllerHelper;
import com.hangjiang.framework.helper.IocHelper;
import com.hangjiang.framework.util.ClassUtil;

/**
 * Created by jianghang on 2017/7/26.
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for(Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
