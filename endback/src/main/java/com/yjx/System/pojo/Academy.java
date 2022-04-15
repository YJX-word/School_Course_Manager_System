package com.yjx.System.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class Academy {
    private String id;
    private String name;
    private List<Course> courses;
}
