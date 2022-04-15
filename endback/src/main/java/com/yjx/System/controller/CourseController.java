package com.yjx.System.controller;

import com.yjx.System.Util.Result;
import com.yjx.System.pojo.Academy;
import com.yjx.System.pojo.Course;
import com.yjx.System.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 9:28
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/getAllCourse")
    public Result<List<Course>> getAllCourse(){
        try {
            List<Course> allCourse = courseService.getAllCourse();
            return new Result<>(1,"succeed",allCourse);
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }

    @GetMapping("/getCourseById/{id}")
    public Result<Course> getCourseById(@PathVariable("id") String id){
        try {
            Course courseById = courseService.getCourseById(id);
            return new Result<>(1,"succeed",courseById );
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }

    @GetMapping("/getAllAcademy")
    public Result<List<Academy>> getAllAcademy(){
        try {
            List<Academy> allAcademy = courseService.getAllAcademy();
            return new Result<>(1,"succeed",allAcademy);
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }

    @PostMapping("/insertCourse")
    public Result<Integer> insertCourse(@RequestBody Course course){
        try {
            int i = courseService.insertCourse(course);
            return new Result<>(1,"succeed",i);
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }

    @PostMapping("/updateCourse")
    public Result<Integer> updateCourse(@RequestBody Course course){
        try {
            int i = courseService.updateCourseHours(course);
            return new Result<>(1,"succeed",i);
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }

    @DeleteMapping("/deleteCourse/{id}")
    public Result<Integer> deleteCourse(@PathVariable("id") String id){
        try {
            int i = courseService.deleteCourse(id);
            return new Result<>(1,"succeed",i);
        } catch (Exception e) {
            return new Result<>(0,e.getMessage(),null);
        }
    }
}
