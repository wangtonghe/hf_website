package com.wthfeng.website.controller;

import com.wthfeng.website.constant.ErrorInfo;
import com.wthfeng.website.constant.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

/**
 * 测试
 *
 * @author wangtonghe
 * @since 2018/3/31 13:13
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return "hello " + name + "!";
    }


    @PostMapping(value = "/testPressure")
    public ResultMsg testPressure(@RequestBody String msg) {
        ResultMsg resultMsg = new ResultMsg();
        handleMsg(msg);
        resultMsg.setErrorInfo(ErrorInfo.OK);
        return resultMsg;
    }


    @Async
    public void handleMsg(String msg) {
        logger.info("msg:{}", msg);
    }


}
