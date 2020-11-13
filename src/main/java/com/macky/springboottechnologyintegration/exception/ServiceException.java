package com.macky.springboottechnologyintegration.exception;

import com.macky.springboottechnologyintegration.entity.enums.ResponseEnum;

/**
 * @Title class ServiceException
 * @Description: TODO
 * @Author Macky
 * @Date 2020/5/25
 */
public class ServiceException extends BaseException {

    public ServiceException(ResponseEnum responseEnum) {
        super(responseEnum);
    }
}
