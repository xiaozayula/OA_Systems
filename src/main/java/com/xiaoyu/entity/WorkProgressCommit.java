package com.xiaoyu.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/27/15:30
 * @Description:
 */
@Data
public class WorkProgressCommit {
    private Long commitId;
    private Long contentId;
    private Long groupId;
    private Long userId; // 提交者的ID
    private String description;//描述这次提交内容
    private LocalDateTime commitTime; // 提交时间

}