package com.xiaoyu.service;

import com.xiaoyu.entity.Request;
import com.xiaoyu.enums.ApplicationStatus;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/15:41
 * @Description:
 */
public interface RequestService {
    void createJoinRequest(Request request,Long todepartmentId);
    void createTransferRequest(Request request,Long todepartmentId);
    void createLeaveRequest (Request request);
    //根据requestid查询用户
    Request selectrequestById(Long requestId);

    boolean approvalJoin(Long requestId, boolean result);

    //查询特定用户的所有加入请求
    List<Request> getUserRequests(Long userId);

    boolean approveTransfer(Long requestId, boolean firstLevelResult, boolean secondLevelResult);

    // 修改方法来处理请假的审批逻辑
    boolean approveLeave(Long requestId, boolean result, String leaveReason);
    void updateLeaveReason(Long requestId, String newReason);
}
