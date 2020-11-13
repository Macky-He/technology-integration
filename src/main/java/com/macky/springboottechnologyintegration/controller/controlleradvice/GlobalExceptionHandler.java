package com.macky.springboottechnologyintegration.controller.controlleradvice;

import com.macky.springboottechnologyintegration.entity.dto.JsonResponse;
import com.macky.springboottechnologyintegration.entity.enums.ResponseEnum;
import com.macky.springboottechnologyintegration.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title class GlobalExceptionHandler
 * @Description: TODO
 * @Author Macky
 * @Date 2020/5/25
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  业务异常
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public JsonResponse businessExceptionHandler(HttpServletRequest request,HttpServletResponse response,ServiceException e)
    {
        log.error("[GlobalExceptionHandler][businessExceptionHandler] exception",e);

        return new JsonResponse().failure(e.getMessage());
    }

    /**
     * 全局异常处理
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request,HttpServletResponse response,Exception e)
    {
        log.error("[GlobalExceptionHandler][exceptionHandler] exception",e);
        return new JsonResponse().failure(ResponseEnum.ERROR);
    }
}