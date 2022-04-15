package com.yjx.System.mapper;

import com.yjx.System.pojo.Academy;
import com.yjx.System.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/8 9:11
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@Repository
public interface course {
    Course getCourseById(@Param("id") String id);
    List<Course> getAllCourse();
    int updateCourseHours(@Param("course")Course course);
    int insertCourse(@Param("course") Course course);
    List<Academy> getAllAcademy();
    int deleteCourse(@Param("id") String id);
}
