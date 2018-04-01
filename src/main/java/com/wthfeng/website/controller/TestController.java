package com.wthfeng.website.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author wangtonghe
 * @since 2018/3/31 13:13
 */
@RestController
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name) {
        return "hello " + name + "!";
    }


}
