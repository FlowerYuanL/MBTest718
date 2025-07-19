package com.lsxp.pojo;

import com.lsxp.annotation.Updatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/*
* 一对一映射
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable {
    private int userId;

    @Updatable
    private String realName;

    @Updatable
    private int age;
}

