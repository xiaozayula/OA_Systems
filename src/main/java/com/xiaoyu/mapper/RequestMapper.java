package com.xiaoyu.mapper;

import com.xiaoyu.entity.Request;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/23/15:33
 * @Description:
 */
@Mapper
public interface RequestMapper {
    //添加新的加入请求
    void insertRequest(@Param("request") Request request);
    //通过requsetId查询加入请求
    Request selectrequestById(@Param("requestId") Long requestId);
    //更新加入请求的状态和相关信息
    void updateRequest(@Param("request") Request request);

    //查询特定用户的所有加入请求
    List<Request> selectUserRequests(@Param("userId")Long userId);
    //更新请假理由
    void updateLeaveReason(@Param("request") Request request);
}
