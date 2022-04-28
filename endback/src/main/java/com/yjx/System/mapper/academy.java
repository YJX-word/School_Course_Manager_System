package com.yjx.System.mapper;

import com.yjx.System.pojo.Academy;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/22 15:58
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@Repository
public interface academy {
    @Select("select * from s_academy")
    List<Academy> getAcademy();
}
