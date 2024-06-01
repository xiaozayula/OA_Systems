package com.xiaoyu.entity;

import com.xiaoyu.enums.ApplicationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import com.xiaoyu.enums.ApplicationType;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/18:18
 * @Description: 审核
 */

@Data
public class Request {

    @NotNull
    private Long requestId;
    @NotNull
    private Long userId;
    @NotNull
    private Long todepartmentId;
    @NotNull
    private Long approverId; // 审核人ID，通常是部门管理员
    private ApplicationType applicationType; // 申请类型JOIN_DEPARTMENT("加入部门"),TRANSFER_DEPARTMENT("转部门"),LEAVE("请假");
    private ApplicationStatus status; // 申请状态， 默认;PENDING("待审核"),SUCCESS("成功"),FAILURE("失败");
    private LocalDateTime requestTime; // 申请时间
    private LocalDateTime approvalTime; // 审核时间

    private String leaveReason; // 仅用于请假申请的请假原因
    private String rejectReason;//仅用于请假申请的拒绝原因
}


