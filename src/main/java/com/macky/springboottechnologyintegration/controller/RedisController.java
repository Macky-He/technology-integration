package com.macky.springboottechnologyintegration.controller;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title class RedisController
 * @Description: TODO
 * @Author Macky
 * @Date 2020/11/4
 */
@RestController
@RequestMapping("/hello")
public class RedisController {


    @RequestMapping("/redis")
    public String redisTest() {
        final RedissonClient redissonClient = Redisson.create();
        return "success";
    }
}
