package com.sq.order.Enums;

import lombok.Getter;

@Getter
public enum PayStatus {

    WAIT(0, "等待支付"),
    FINISHED(1, "完成"),
    ;
    private Integer code;

    private String msg;

    PayStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
