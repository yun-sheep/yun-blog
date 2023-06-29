package com.yun.foregroundmanagement.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 接口测试
 * @auther j2-yizhiyang
 * @date 2023/4/30 14:42
 */
@RestController
@Slf4j
@Api(tags = "test")
@RequestMapping("test")
public class test {
    @GetMapping("name")
    @ApiOperation("测试")
    public String test1(String name){
        log.info("name is "+name);
        return name;

    }
}
