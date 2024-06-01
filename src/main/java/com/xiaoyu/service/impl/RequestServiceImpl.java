package com.xiaoyu.service.impl;

import com.xiaoyu.entity.Request;
import com.xiaoyu.entity.User;
import com.xiaoyu.enums.ApplicationStatus;
import com.xiaoyu.enums.ApplicationType;
import com.xiaoyu.mapper.RequestMapper;
import com.xiaoyu.mapper.UserMapper;
import com.xiaoyu.service.RecordService;
import com.xiaoyu.service.RequestService;
import com.xiaoyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.xiaoyu.enums.ApplicationStatus.SUCCESS;
import static com.xiaoyu.enums.ApplicationType.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/15:41
 * @Description:
 */

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private UserService userService;
    private RecordService recordService;
    @Autowired
    private UserMapper userMapper;

    //创建加入部门请求
    @Override
    public void createJoinRequest(Request request, Long todepartmentId) {
        request.setApplicationType(JOIN_DEPARTMENT);
        request.setStatus(ApplicationStatus.PENDING);
        request.setRequestTime(LocalDateTime.now());
        request.setTodepartmentId(todepartmentId);
        requestMapper.insertRequest(request);
    }

    //创建转部门请求
    @Override
    public void createTransferRequest(Request request, Long todepartmentId) {
        request.setApplicationType(JOIN_DEPARTMENT);
        request.setStatus(ApplicationStatus.PENDING);
        request.setRequestTime(LocalDateTime.now());
        request.setTodepartmentId(todepartmentId);
        requestMapper.insertRequest(request);
    }

    // 创建请假请求
    @Override

    public void createLeaveRequest(Request request) {
        request.setApplicationType(LEAVE);
        request.setStatus(ApplicationStatus.PENDING);
        request.setRequestTime(LocalDateTime.now());
        requestMapper.insertRequest(request);
    }

    @Override
    public Request selectrequestById(Long requestId) {
        return requestMapper.selectrequestById(requestId);
    }

    @Override
    public boolean approvalJoin(Long requestId, boolean result) {
        Request request = selectrequestById(requestId);
        request.setApprovalTime(LocalDateTime.now());
        if (result) {
            // 如果审批通过，更新用户部门信息
            userService.updateUserDepartment(request.getUserId(),request.getTodepartmentId());
            // 更新请求状态为成功
            request.setStatus(SUCCESS);

        } else {
            request.setStatus(ApplicationStatus.FAILURE);
                }
        requestMapper.updateRequest(request);
        // 添加记录到Record表
        recordService.addRecord(request.getUserId(), request.getRequestId(), JOIN_DEPARTMENT, request.getStatus(), LocalDateTime.now(), null);
        return result;
    }

    @Override
    public List<Request> getUserRequests(Long userId) {
        return requestMapper.selectUserRequests(userId);
    }

    @Override
    public boolean approveTransfer(Long requestId, boolean firstLevelResult, boolean secondLevelResult) {
        Request request = selectrequestById(requestId);
        request.setApprovalTime(LocalDateTime.now());
        if (firstLevelResult) {
            request.setStatus(ApplicationStatus.AWAITING_SECOND_APPROVAL);
        } else {
            request.setStatus(ApplicationStatus.FAILURE);

            return false;
        }
        requestMapper.updateRequest(request);

        if (secondLevelResult) {
            request.setStatus(SUCCESS);
            userService.updateUserDepartment(request.getUserId(),request.getTodepartmentId());
        } else {
            request.setStatus(ApplicationStatus.FAILURE);
        }
        requestMapper.updateRequest(request);
        recordService.addRecord(request.getUserId(), request.getRequestId(), TRANSFER_DEPARTMENT, request.getStatus(), LocalDateTime.now(), null);
        return secondLevelResult;
    }

    // 处理请假的审批
    // 新增方法来处理请假的审批逻辑
    @Override
    public boolean approveLeave(Long requestId, boolean result,String rejectReason) {
        Request request = selectrequestById(requestId);
        if (result) {
            request.setStatus(SUCCESS);
        } else {
            request.setStatus(ApplicationStatus.FAILURE);
            // 如果提供了驳回原因，更新请假原因
            if (rejectReason != null && !rejectReason.isEmpty()) {
                updateLeaveReason(requestId, rejectReason);
            }
        }
        requestMapper.updateRequest(request);
        recordService.addRecord(request.getUserId(), request.getRequestId(), LEAVE, request.getStatus(), LocalDateTime.now(), null);
        return result;
    }

    // 新增方法来更新请假原因
    @Override
    public void updateLeaveReason(Long requestId, String newReason) {
        Request request = selectrequestById(requestId);
        if (newReason != null && !newReason.isEmpty()) {
            request.setLeaveReason(newReason);
            requestMapper.updateLeaveReason(request);
        }
    }
}




