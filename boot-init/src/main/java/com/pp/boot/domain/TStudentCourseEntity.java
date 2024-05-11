package com.pp.boot.domain;

import java.io.Serializable;

import lombok.Data;


/**
 * (TStudentCourse)实体类
 *
 * @author makejava
 * @since 2024-05-09 13:42:20
 */


@Data

public class TStudentCourseEntity implements Serializable {
    private static final long serialVersionUID = -24458572614954754L;

    private Integer id;


    private Integer studentId;


    private Integer courseId;


}

