package com.xiaoyu.mapper;

import com.xiaoyu.entity.Permit;
import com.xiaoyu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/05/15/14:56
 * @Description:
 */
@Mapper
public interface UserMapper {

    User findByUserName(String userName) ;
    //根据id查找用户
    User selectUserById(Long id);

    void register(String username, String md5String);

    String getDepartmentNameByUserId( Long userId);

    List<User> selectUsersByDepartmentId(@Param("departmentId")Long departmentId);

    void updateUserDepartment(User user);

    Long selectDepartmentIdByUserId(Long userId);
    List<Permit> getPermitByUserId(Long userId);


}
