package com.macky.springboottechnologyintegration.controller.controlleradvice;

import com.macky.springboottechnologyintegration.entity.dto.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Macky
 * @Title class RestValidateExceptionHandler
 * @Description: TODO
 * @date 2019/11/6 10:02
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.macky.springboottechnologyintegration.controller")
public class RestValidateExceptionHandler {
    //处理数据验证异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResponse validationErrorHandler(MethodArgumentNotValidException ex) {
        // 同样是获取BindingResult对象，然后获取其中的错误信息
        // 如果前面开启了fail_fast，事实上这里只会有一个信息
        //如果没有，则可能又多个
        List<String> errorInformation = ex.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        log.error("系统异常：{}", errorInformation.toString());
        return new JsonResponse().failure(errorInformation.toString());
    }

    //处理其余异常
    @ExceptionHandler(Exception.class)
    public JsonResponse exceptionHandler(Exception e) {
        log.error("系统异常：{}", e.getMessage());
        return new JsonResponse().failure(e.getMessage());
    }
}