package com.macky.springboottechnologyintegration.controller;

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
    public String helloJenkins(){
        return "Hello Jenkins!!! this is first change!";
    }
}
