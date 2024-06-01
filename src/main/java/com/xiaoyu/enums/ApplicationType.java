package com.xiaoyu.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/13/20:07
 * @Description: 审核内容：'加入部门', '转部门', '请假'
 */
public enum ApplicationType {
    JOIN_DEPARTMENT("加入部门"),
    TRANSFER_DEPARTMENT("转部门"),
    LEAVE("请假");
    //声明属性
    private final String label;

    ApplicationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    // 获取默认状态为"待审核"
    public static ApplicationType getDefaultStatus() {
        return JOIN_DEPARTMENT;
    }
}
