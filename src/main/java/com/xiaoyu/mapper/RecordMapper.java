package com.xiaoyu.mapper;

import com.xiaoyu.entity.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/30/20:00
 * @Description:
 */
@Mapper
public interface RecordMapper {
    int insertRecord(Record record);
    List<Record> selectAllRecords();
    // 其他必要的CRUD方法
}
