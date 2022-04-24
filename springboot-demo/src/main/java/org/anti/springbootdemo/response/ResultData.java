package org.anti.springbootdemo.response;

import lombok.Data;

@Data
public class ResultData<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> ResultData<T> create(ReturnCode returnCode) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(returnCode.getCode());
        resultData.setMessage(returnCode.getMessage());
        return resultData;
    }

    public static <T> ResultData<T> create(ReturnCode returnCode, T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(returnCode.getCode());
        resultData.setMessage(returnCode.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> create(Integer code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }

    public static <T> ResultData<T> success(String message) {
        return create(ReturnCode.SUCCESS.getCode(), message);
    }

    public static <T> ResultData<T> success(T data) {
        return create(ReturnCode.SUCCESS, data);
    }

    public static <T> ResultData<T> fail() {
        return create(ReturnCode.FAILURE);
    }

    public static <T> ResultData<T> fail(String message) {
        return create(ReturnCode.FAILURE.getCode(), message);
    }

}
