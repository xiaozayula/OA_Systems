package com.xiaoyu.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/18:01
 * @Description:
 */

@Data
public class WorkContent {
    @NotNull
    private  Long contentId;
    private  Long groupId;
    private  String content;
    private  LocalDate deadline;//截至日期
    // 是否已结束
    private boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }
}
