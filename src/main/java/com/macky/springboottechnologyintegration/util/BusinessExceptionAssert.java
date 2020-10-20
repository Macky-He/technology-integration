package com.macky.springboottechnologyintegration.util;

import com.macky.springboottechnologyintegration.entity.enums.ResponseEnum;
import com.macky.springboottechnologyintegration.exception.BaseException;
import com.macky.springboottechnologyintegration.exception.ServiceException;

import java.text.MessageFormat;

/**
 * @author Macky
 * @Title interface BusinessExceptionAssert
 * @Description: TODO
 * @date 2020/5/25
 */
public interface BusinessExceptionAssert extends Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ServiceException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ServiceException(this, args, msg, t);
    }

}