package com.xiaoyu.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/20:08
 * @Description: 审核状态：('待审核', '成功', '失败')
 */

public enum ApplicationStatus {

    PENDING("待审核"),
    SUCCESS("成功"),
    AWAITING_SECOND_APPROVAL("等待第二个部门审批"),
    DISMISSED("驳回"),
    FAILURE("失败");


    //声明属性
    private final String label;

    ApplicationStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    // 获取默认状态为"待审核"
    public static ApplicationStatus getDefaultStatus() {
        return PENDING;
    }
}
