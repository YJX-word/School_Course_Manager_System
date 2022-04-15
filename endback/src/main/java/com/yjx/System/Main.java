package com.yjx.System;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 17:53
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@SpringBootApplication
@MapperScan("com.yjx.System.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
