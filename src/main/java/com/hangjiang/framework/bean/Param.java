package com.hangjiang.framework.bean;

import com.hangjiang.framework.util.CastUtil;

import java.util.Map;

/**
 * Created by jianghang on 2017/7/26.
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap){
        this.paramMap = paramMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getMap(){
        return paramMap;
    }
}
