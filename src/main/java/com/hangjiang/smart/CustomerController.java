package com.hangjiang.smart;

import com.hangjiang.framework.annotation.Action;
import com.hangjiang.framework.annotation.Controller;
import com.hangjiang.framework.bean.Data;
import com.hangjiang.framework.bean.Param;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianghang on 2017/7/30.
 */
@Controller
public class CustomerController {

    @Action("get:/customer_show")
    public Data show(Param param){
        Map<String,String> map = new HashMap<String, String>();
        map.put("smart","framework");

        return new Data(map);
    }
}
