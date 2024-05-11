package com.pp.boot.domain;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;


/**
 * (TCourse)实体类
 *
 * @author makejava
 * @since 2024-05-09 13:42:17
 */


@Data

public class TCourseEntity implements Serializable {
    private static final long serialVersionUID = -70844279383780561L;

    private Integer courseId;


    private String courseName;


    private String description;


    private String teacher;


    private Date startDate;


    private Date endDate;


}

