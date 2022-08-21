package org.anti.springbootdemo.response;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> create(ReturnCode returnCode) {
        Result<T> result = new Result<>();
        result.setCode(returnCode.getCode());
        result.setMessage(returnCode.getMessage());
        return result;
    }

    public static <T> Result<T> create(ReturnCode returnCode, T data) {
        Result<T> result = new Result<>();
        result.setCode(returnCode.getCode());
        result.setMessage(returnCode.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> create(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> success(String message) {
        return create(ReturnCode.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> success(T data) {
        return create(ReturnCode.SUCCESS, data);
    }

    public static <T> Result<T> fail() {
        return create(ReturnCode.FAILURE);
    }

    public static <T> Result<T> fail(String message) {
        return create(ReturnCode.FAILURE.getCode(), message);
    }

}
