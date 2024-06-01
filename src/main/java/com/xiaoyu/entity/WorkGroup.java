package com.xiaoyu.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/17:54
 * @Description:
 */
@Data
public class WorkGroup {
    @NotNull
    private  Long  groupId;
    private Long departmentId;
    @NotNull
    private String groupName;
    @NotNull
    private  Long leaderId;//这个工作组的领导人

}
