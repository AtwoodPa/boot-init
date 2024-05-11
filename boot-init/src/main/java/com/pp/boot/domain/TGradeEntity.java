package com.pp.boot.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;


/**
 * (TGrade)实体类
 *
 * @author makejava
 * @since 2024-05-09 13:42:18
 */


@Data

public class TGradeEntity implements Serializable {
    private static final long serialVersionUID = 975327961935664721L;

    private Integer gradeId;


    private Integer studentId;


    private Integer courseId;


    private BigDecimal score;


    private Date gradeDate;


}

