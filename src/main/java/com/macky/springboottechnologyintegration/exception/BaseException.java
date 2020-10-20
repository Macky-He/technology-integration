package com.macky.springboottechnologyintegration.exception;

import com.macky.springboottechnologyintegration.entity.enums.ResponseEnum;
import lombok.Data;

/**
 * @Title class BaseException
 * @Description: TODO
 * @Author Macky
 * @Date 2020/5/25
 */
@Data
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;

    public BaseException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
    }
}
