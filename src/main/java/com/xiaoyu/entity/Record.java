package com.xiaoyu.entity;

import com.xiaoyu.enums.ApplicationStatus;
import com.xiaoyu.enums.ApplicationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/30/19:57
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Long recordId;
    private Long userId;
    private Long requestId;
    private ApplicationType applicationType;
    private ApplicationStatus status;
    private LocalDateTime actionTime;
    private String details;
}

