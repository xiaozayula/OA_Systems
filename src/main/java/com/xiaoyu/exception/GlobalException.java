package com.xiaoyu.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.xiaoyu.Satoken.AjaxJson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/26/19:42
 * @Description: 全局异常处理:下面的异常会在鉴权失败的时候自动返回到前端，无需我们手动抛出和返回
 */
@ControllerAdvice
public class GlobalException {
    // 全局异常拦截（拦截项目中的所有异常）
    @ResponseBody
    @ExceptionHandler
    public AjaxJson handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) {

        // 打印堆栈，以供调试
        System.out.println("全局异常---------------");
//        System.out.println(e.getMessage());

        // 不同异常返回不同状态码
        AjaxJson aj = null;
        // 如果是未登录异常
        if (e instanceof NotLoginException) {
            NotLoginException ee = (NotLoginException) e;
            aj = AjaxJson.getNotLogin().setMsg(ee.getMessage());
        }
        // 如果是角色异常
        else if (e instanceof NotRoleException) {
            NotRoleException ee = (NotRoleException) e;
            aj = AjaxJson.getNotJur("无此角色：" + ee.getRole());
        }
        // 如果是权限异常
        else if (e instanceof NotPermissionException) {
            NotPermissionException ee = (NotPermissionException) e;
            aj = AjaxJson.getNotJur("无此权限：" + ee.getCode());
        }

        // 返回给前端
        return aj;
    }

}