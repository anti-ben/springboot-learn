package org.anti.springbootdemo.response;

public enum ReturnCode {

    //10000开头为通用错误类型
    SUCCESS(10000,"操作成功"),
    FAILURE(99999,"操作失败"),
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),
    INVALID_TOKEN(12001,"访问令牌不合法"),
    ACCESS_DENIED(12003,"没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(11001,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(11002,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(11003, "不支持的认证模式"),
    ILLEGAL_ARGUMENT(13001,"非法参数"),

    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_LOGIN_FAIL(20002, "用户手机号或密码不正确"),
    USER_NOT_LOGIN(20003, "用户还未登录"),

    //3000开头为交易信息错误
    STOCK_NOT_ENOUGH(30001, "库存不足"),
    MQ_SEND_FAIL(30002, "库存异步消息失败"),
    RATELIMIT(30003, "活动太火爆，稍后再试");

    private final Integer code;
    private final String message;

    ReturnCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
