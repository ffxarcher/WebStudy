package com.sq.client.exception;

import com.sq.client.enums.ResultEnum;

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
