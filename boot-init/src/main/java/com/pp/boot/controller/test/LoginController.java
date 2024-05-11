package com.pp.boot.controller.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 * @author supanpan
 * @create 2024/05/08 12:46
 */
@RestController
public class LoginController {


    @RequestMapping("/index")
    public String index(){
        return "login success";
    }

    @RequestMapping("/hello")
    public String hello(){return "hello security";
    }
}
