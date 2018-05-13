package com.wthfeng.website.constant;

/**
 * 错误码
 *
 * @author wangtonghe
 * @since 2018/3/31 14:18
 */
public enum ErrorInfo {

    /**
     * 操作成功
     */
    OK(0, "操作成功"),

    /**
     * 未知异常错误
     */
    UNKNOWN(1, "未知错误"),

    INNER_ERROR(2, "系统内部错误"),


    /**
     * 参数不全 (10-19,参数问题)
     */
    PARAM_NULL(10, "参数为空或部分为空"),

    /**
     * 参数格式错误
     */
    PARAM_FORMAT_ERROR(11, "参数格式错误"),

    /**
     * 密码错误（21-29,验证问题)
     */
    PASSWORD_ERROR(21, "密码错误"),

    /**
     * 数据库异常，100-120
     */
    DATA_ACCESS_EXCEPTION(100, "数据库访问异常");


    private int code;

    private String desc;

    ErrorInfo(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
