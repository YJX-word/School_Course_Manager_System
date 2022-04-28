package com.yjx.System.controller;

import com.yjx.System.Util.Result;
import com.yjx.System.pojo.Academy;
import com.yjx.System.pojo.Course;
import com.yjx.System.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 9:28
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@RestController
@CrossOrigin(allowedHeaders = "*",originPatterns = "http://localhost:8080",origins = "http://localhost:8080")
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
    public Result<String> insertCourse(@RequestBody Course course){
        try {
            if(course.getPicUrl().equals("")){
                course.setPicUrl("http://localhost:8000/images/01f40c3a-f678-47aa-bd61-2dce90808d0d.png");
            }
            courseService.insertCourse(course);
            Course courseByName = courseService.getCourseByName(course.getName());
            return new Result<>(1,"succeed",courseByName.getId());
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

    @PostMapping("/pic_show")
    public String insert_storeList(
            @RequestParam("picFile") MultipartFile picFile
    ){
        String uuid = UUID.randomUUID().toString();
        try {
            picFile.transferTo(new File("E://pic_service//coursePic//"+uuid+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid;
    }
}
