package com.wthfeng.website.interceptor;

import com.wthfeng.website.constant.ErrorInfo;
import com.wthfeng.website.constant.ResultMsg;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author wangtonghe
 * @since 2018/4/1 13:54
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMsg defaultErrorHandler(Exception e) {

        ResultMsg resultMsg = new ResultMsg();

        //数据访问失败
        if (e instanceof DataAccessException) {
            resultMsg.setErrorInfo(ErrorInfo.DATA_ACCESS_EXCEPTION);

        } else {
            resultMsg.setErrorInfo(ErrorInfo.INNER_ERROR);

        }
        return resultMsg;
    }


}
