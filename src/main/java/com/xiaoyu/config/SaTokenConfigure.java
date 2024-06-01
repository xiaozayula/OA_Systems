package com.xiaoyu.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/26/18:17
 * @Description:
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，定义详细认证规则
        registry.addInterceptor(new SaInterceptor(handler -> {
        SaRouter
                .match("/**")   // 拦截的 path 列表，可以写多个 */
                .notMatch("/user/login", "/user/register")      // 排除掉的 path 列表，可以写多个
                .check(r -> StpUtil.checkLogin());      // 登录校验拦截器

            // 角色校验 -- 拦截 的路由，必须具备admin:super角色或者admin:dept角色才可以通过认证
            SaRouter.match("/requests/{requestId}/*", r -> StpUtil.checkRoleOr("admin:super ", "admin:dept"));
            SaRouter.match("/departments/{departmentId}/publishNotice", r -> StpUtil.checkRoleOr("admin:super ", "admin:dept"));
            SaRouter.match("/workgroups/createWorkGroup", r -> StpUtil.checkRoleOr("admin:super ", "admin:dept"));
            SaRouter.match("/admin/records", r -> StpUtil.checkRoleOr("admin:super "));

    })).addPathPatterns("/**");


//        开始我是结合@SaCheckPermission(value = {"admin:super", "admin:dept"} ,mode = SaMode.OR)注解鉴权
//        现在改为上面的路由鉴权了
//        注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
//        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}