package com.yjx.System.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Yjx
 * @Data: 2022/4/8 9:05
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String id;
    private String name;
    private String hours;
    private String sid;
    private String picUrl;
}
