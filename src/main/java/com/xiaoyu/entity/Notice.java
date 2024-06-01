package com.xiaoyu.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/17:36
 * @Description: 公告表
 */
@Data
public class Notice {

    @NotNull
    private Long noticeId;
    private Long departmentId;
    @NotNull
    private String title;
    private String content;
    //发布时间
    private LocalDateTime publishTime;

}
