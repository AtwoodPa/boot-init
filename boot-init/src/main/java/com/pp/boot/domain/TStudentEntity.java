package com.pp.boot.domain;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;


/**
 * (TStudent)实体类
 *
 * @author makejava
 * @since 2024-05-09 13:42:19
 */


@Data

public class TStudentEntity implements Serializable {
    private static final long serialVersionUID = 250394267347146016L;

    private Integer studentId;


    private String studentName;


    private Integer age;


    private Object gender;


    private String address;


    private String email;


    private String phone;


    private Date dateOfBirth;


}

