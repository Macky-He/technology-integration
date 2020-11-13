package com.macky.springboottechnologyintegration.entity.enums;


import com.macky.springboottechnologyintegration.exception.ServiceException;
import com.macky.springboottechnologyintegration.util.BusinessExceptionAssert;

/**
 * @author Macky
 * @Title enum ResponseEnum
 * @Description: TODO
 * @date 2020/5/25
 */
public enum ResponseEnum {

    ERROR(0,"系统异常"),
    SUCESS(1,"成功");
    
    private Integer code;
    private String msg;

    ResponseEnum(int i, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
