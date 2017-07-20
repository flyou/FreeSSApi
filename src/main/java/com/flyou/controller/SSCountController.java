package com.flyou.controller;

import com.flyou.bean.SSBean;
import com.flyou.bean.SSRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author       : flyou
 * Date         : 2017/7/11 0011.
 * FileName     : UserController
 * ProjectName  : SpringApi
 * Description  :
 * Version      : V1.0
 */

@RestController
public class SSCountController {
    @Autowired
    private SSRespository ssRespository;
    @RequestMapping("/getAccount")
    public Iterable<SSBean> getSSAccount() {
        Iterable<SSBean> all = ssRespository.findAll();
        return all;
    }
}
