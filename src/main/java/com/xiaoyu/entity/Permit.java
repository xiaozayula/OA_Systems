package com.xiaoyu.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/26/18:22
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permit {
    @NotNull
    private Long PermitId;
    private String permitName;
    private  String url;
}
