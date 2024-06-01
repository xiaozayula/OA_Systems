package com.xiaoyu.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/17:50
 * @Description:部门表
 */
@Data
public class Department {

    @NotNull
    private Long departmentId;
    @NotNull
    private String departmentName;
}
