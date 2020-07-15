package com.tzgod.user.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
