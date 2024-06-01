package com.xiaoyu.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xiaoyu.entity.Record;
import com.xiaoyu.entity.Request;
import com.xiaoyu.entity.Result;
import com.xiaoyu.entity.User;
import com.xiaoyu.enums.ApplicationStatus;
import com.xiaoyu.service.RequestService;
import com.xiaoyu.service.UserService;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/15:42
 * @Description:
 */
@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @PostMapping("/createJoin")//创建新加入请求
    public Result<Void> createJoinRequest(@RequestBody Request request,Long todepartmentId) {
        requestService.createJoinRequest(request,todepartmentId);
        return Result.success();
    }
    @PostMapping("/createTransfer")//创建转部门请求
    public Result<Void> createTransferRequest(@RequestBody Request request,Long todepartmentId) {
        requestService.createTransferRequest(request,todepartmentId);
        return Result.success();
    }

    @PostMapping("/createLeave")//创建转部门请求
    public Result<Void> createLeaveRequest(@RequestBody Request request) {
        requestService.createLeaveRequest(request);
        return Result.success();
    }
    //加入部门
    //SaMode.AND ，标注一组权限，会话必须全部具有才可通过校验
    @PutMapping("/{requestId}/addDepartment")
    public Result<String> addDepartment(@PathVariable Long requestId, @RequestParam boolean result) {
        Request request = requestService.selectrequestById(requestId);
        User user = userService.selectUserById(request.getUserId());
        if (user != null && user.getDepartmentId() != null) {
            throw new RuntimeException("用户已加入其他部门");
        }
        if (requestService.approvalJoin(requestId, result)) {
            return Result.success("加入部门成功");
        } else {
            return Result.error("加入部门失败，审批未通过");
        }
    }
    //处理转部门的审批
    @PutMapping("/{requestId}/approveTransfer")
    public Result<String> approveTransfer(@PathVariable Long requestId, @RequestParam boolean firstLevelResult, @RequestParam boolean secondLevelResult) {
        if (requestService.approveTransfer(requestId, firstLevelResult, secondLevelResult)) {
            return Result.success("转部门审批成功");
        } else {
            return Result.error("转部门审批失败");
        }
    }
    //处理请假的审批

    @PutMapping("/{requestId}/approveLeave")
    public Result<String> approveLeave(@PathVariable Long requestId, @RequestParam boolean result, @RequestParam(required = false) String rejectReason) {
        if (requestService.approveLeave(requestId, result, rejectReason)) {
            return Result.success("请假审批成功");
        } else {
            if (rejectReason != null && !rejectReason.isEmpty()) {
                return Result.error("请假审批被驳回，请修改请假原因"  );
            } else {
                return Result.error("请假审批被驳回");
            }
        }
    }

    @PutMapping("/updateLeaveReason")
    public Result<String> updateLeaveReason(@PathVariable Long requestId,  String newReason) {
        requestService.updateLeaveReason(requestId, newReason);
        return Result.success("请假原因更新成功");
    }

}
