package com.yjx.System.service;

import com.yjx.System.mapper.course;
import com.yjx.System.pojo.Academy;
import com.yjx.System.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 8:51
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@Service(value = "CourseServiceImpl")
public class CourseServiceImpl implements CourseService{
    @Autowired
    course course;

    @Override
    public Course getCourseById(String id) {
        return course.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> allCourse = course.getAllCourse();
        return allCourse;
    }

    @Override
    public int updateCourseHours(Course courses) {
        return course.updateCourseHours(courses);
    }

    @Override
    public int insertCourse(Course courses) {
        return course.insertCourse(courses);
    }

    @Override
    public List<Academy> getAllAcademy() {
        return course.getAllAcademy();
    }

    @Override
    public int deleteCourse(String id) {
        return course.deleteCourse(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return course.getCourseByName(name);
    }
}
