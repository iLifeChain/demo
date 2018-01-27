package com.ilifediary.blockchain.demo.api.entity;

import lombok.ToString;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 焦晨宇
 * @date 2018/01/27
 */
@ToString
public class ResultCode {
    /**
     * 成功
     */
    public static final ResultCode SUCCESS = new ResultCode(0, "success");
    /**
     * 失败
     */
    public static final ResultCode SYSTEM_ERROR = new ResultCode(-1, "system error");
    /**
     * 未登录
     */
    public static final ResultCode ANONYMOUS = new ResultCode(-100, "anonymous");

    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return code >= 0;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResultCode && code == ((ResultCode)o).code;
    }

    @Override
    public int hashCode() {
        return code;
    }
}
