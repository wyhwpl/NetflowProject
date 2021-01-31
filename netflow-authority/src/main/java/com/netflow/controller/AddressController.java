package com.netflow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflow.bean.User;
import com.netflow.common.ErrorMsg;
import com.netflow.common.PageResult;
import com.netflow.mapper.AddressMapper;
import com.netflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 汪培林
 * @data 2020-12-24  13:36:41
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController{

    @Autowired
    private AddressMapper addressMapper;

    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public ErrorMsg getAll(){
        System.out.println("start get address");
        return new ErrorMsg("0","success",addressMapper.getProvinceByCode());
    }

}
