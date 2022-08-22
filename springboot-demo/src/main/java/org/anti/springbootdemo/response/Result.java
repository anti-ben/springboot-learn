package org.anti.springbootdemo.response;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> create(ReturnCode returnCode) {
        Result<T> result = new Result<>();
        result.setCode(returnCode.getCode());
        result.setMsg(returnCode.getMsg());
        return result;
    }

    public static <T> Result<T> create(ReturnCode returnCode, T data) {
        Result<T> result = new Result<>();
        result.setCode(returnCode.getCode());
        result.setMsg(returnCode.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> create(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> success(String msg) {
        return create(ReturnCode.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> success(T data) {
        return create(ReturnCode.SUCCESS, data);
    }

    public static <T> Result<T> fail() {
        return create(ReturnCode.FAILURE);
    }

    public static <T> Result<T> fail(String msg) {
        return create(ReturnCode.FAILURE.getCode(), msg);
    }

}
