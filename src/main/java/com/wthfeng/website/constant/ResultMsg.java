package com.wthfeng.website.constant;

/**
 * 返回结果类
 *
 * @author wangtonghe
 * @since 2018/3/31 14:11
 */
public class ResultMsg {


    public static int OK = 0;

    /**
     * 结果标识码，0 代表正确
     */
    private int code;

    /**
     * 错误描述
     */
    private String desc;

    /**
     * 返回结果
     */
    private Object data;

    public ResultMsg() {

    }

    public ResultMsg(int code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public ResultMsg(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.desc = errorInfo.getDesc();
    }

    public ResultMsg(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ResultMsg(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.desc = errorInfo.getDesc();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
