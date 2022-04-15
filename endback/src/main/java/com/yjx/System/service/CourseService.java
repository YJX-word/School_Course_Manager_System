package com.yjx.System.service;

import com.yjx.System.pojo.Academy;
import com.yjx.System.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 8:50
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
public interface CourseService {
    public Course getCourseById(String id);
    public List<Course> getAllCourse();
    public int updateCourseHours(Course course);
    public int insertCourse(Course course);
    List<Academy> getAllAcademy();
    int deleteCourse(String id);
}
