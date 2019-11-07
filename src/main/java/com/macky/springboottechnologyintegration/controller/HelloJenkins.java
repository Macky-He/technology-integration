package com.macky.springboottechnologyintegration.controller;

import com.macky.springboottechnologyintegration.entity.dto.JsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Macky
 * @Title class HelloJenkins
 * @Description: TODO
 * @date 2019/10/31 16:40
 */
@RestController
@RequestMapping("/hello")
public class HelloJenkins {

    @RequestMapping("/jenkins")
    public JsonResponse helloJenkins() {
        String result = "异常统一处理controllerAdvice已完成！统一返回修改成功！";
        return new JsonResponse().success(result);
    }
}
