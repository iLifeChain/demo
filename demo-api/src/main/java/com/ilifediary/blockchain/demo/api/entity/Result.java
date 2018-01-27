package com.ilifediary.blockchain.demo.api.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 焦晨宇
 * @date 2018/01/27
 */
@ToString
@EqualsAndHashCode
public class Result<T> {

    private ResultCode resultCode;

    private T data;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.data = null;
    }

    public Result(ResultCode resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public boolean isSuccess() {
        return resultCode.isSuccess();
    }
}
