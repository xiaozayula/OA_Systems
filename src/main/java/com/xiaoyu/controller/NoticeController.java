package com.xiaoyu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xiaoyu.entity.Notice;
import com.xiaoyu.entity.Result;
import com.xiaoyu.service.NoticeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/22/16:00
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/departments")
public class NoticeController {
    @Autowired
    private  NoticeService noticeService;
    //通过部门id查询部门的公告
    @GetMapping("/{departmentId}/notices")
    public Result<List<Notice>> getNoticesByDepartmentId(@PathVariable Long departmentId){
        List<Notice> notices = noticeService.getNoticesByDepartmentId(departmentId);
        if (!notices.isEmpty()){
            return  Result.success(notices);
        }else {
            return  Result.error("未找到该部门的公告信息");
        }
    }

    //发布公告
    @PostMapping("/{departmentId}/publishNotice")
    public Result publishNotice(@PathVariable Long departmentId, @RequestBody @Valid Notice notice) {//@Valid注解来触发Bean Validation,对传入的数据进行验证，确保公告的内容不为空或有正确的格式。
        try {
            notice.setDepartmentId(departmentId);
            noticeService.publishNotice(notice);
            log.info("公告已成功发布到部门ID: {}", departmentId);
            return Result.success();
        } catch (IllegalArgumentException e) {
            log.error("发布公告时发生错误: {}", e.getMessage());
            return Result.error("发布公告失败，请检查输入数据");
        } catch (Exception e) {
            log.error("发布公告时发生未知错误", e);
            return Result.error("发布公告失败，请联系管理员");
        }
    }
}
