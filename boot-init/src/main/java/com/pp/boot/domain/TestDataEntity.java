package com.pp.boot.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import lombok.Data;


/**
 * (TestData)实体类
 *
 * @author makejava
 * @since 2024-05-09 13:42:16
 */


@Data

public class TestDataEntity implements Serializable {
    private static final long serialVersionUID = -36539319205410355L;

    private Integer id;


    private String name;


    private Integer age;


    private String email;


    private Date birthday;


    private BigDecimal height;


    private BigDecimal weight;


    private Boolean active;


    private Date createdAt;


}

