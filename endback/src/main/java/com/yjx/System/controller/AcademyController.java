package com.yjx.System.controller;

import com.yjx.System.Util.Result;
import com.yjx.System.pojo.Academy;
import com.yjx.System.service.AcademyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/22 16:01
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders = "http://localhost:8080",originPatterns = "http://localhost:8080")
public class AcademyController {
    @Autowired
    AcademyServiceImpl academyService;

    @GetMapping("/getAcademy")
    public Result<List<Academy>> getAcademy(){
        try{
            List<Academy> allAcademy = academyService.getAcademy();
            return new Result<>(1,"succeed",allAcademy);
        }catch (Exception e){
            return new Result<>(0,e.getMessage(),null);
        }
    }

}
