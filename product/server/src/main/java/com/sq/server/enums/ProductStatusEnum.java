package com.sq.server.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    up(0, "上架"),
    down(1, "下架");

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;


}
