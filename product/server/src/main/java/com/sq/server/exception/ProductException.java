package com.sq.server.exception;


import com.sq.server.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
