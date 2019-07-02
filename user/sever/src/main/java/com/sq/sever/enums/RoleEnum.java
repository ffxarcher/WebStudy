package com.sq.sever.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    BUYER(1,"卖家"),
    SELLER(2,"买家");

    private Integer code;
    private String msg;


    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
