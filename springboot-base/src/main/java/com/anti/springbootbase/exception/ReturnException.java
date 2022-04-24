package com.anti.springbootbase.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnException {
    private Integer code;
    private String msg;
    private String url;
}
