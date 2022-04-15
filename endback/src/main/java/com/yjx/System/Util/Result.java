package com.yjx.System.Util;

import lombok.ToString;

/**
 * @Author: Yjx
 * @Data: 2022/4/15 20:14
 * @Version 1.0
 * @Project_Name: School_Course_ManagerSystem
 * @describe
 */
@ToString
public class Result<T> {
    public int code;
    public String msg;
    public T data;
    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
