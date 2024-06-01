package com.xiaoyu.controller;

import com.xiaoyu.entity.Record;
import com.xiaoyu.entity.Result;
import com.xiaoyu.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/30/20:08
 * @Description:
 */
@RestController
@RequestMapping("/admin")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/records")
    public Result<List<Record>> getAllRecords() {
        List<Record> records = recordService.getAllRecords();
        return Result.success(records);
    }
}