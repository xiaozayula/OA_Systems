package com.xiaoyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/18/17:38
 * @Description:
 */

@RestController
@RequestMapping("/error")
public class ErrorController {
    //跳转到权限不足提示页面
    @RequestMapping("/noAuth")
    public String toNoAuth(){
        return "/error/noAuth";
    }
}