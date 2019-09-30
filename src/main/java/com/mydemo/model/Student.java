package com.mydemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wuwei
 * @create 2019/9/30 9:14
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;
    private Integer age;
    private String nickName;
    private Date createDate;
}
