package com.yjx.System.service;

import com.yjx.System.mapper.academy;
import com.yjx.System.pojo.Academy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yjx
 * @Data: 2022/4/22 16:00
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@Service
public class AcademyServiceImpl implements AcademyService{
    @Autowired
    academy academy;

    @Override
    public List<Academy> getAcademy() {
        return academy.getAcademy();
    }
}
