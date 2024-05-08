package com.pp.boot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * test_data
 * @author supan
 */
@Data
public class TestData implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private Date birthday;

    private BigDecimal height;

    private BigDecimal weight;

    private Boolean active;

    private Date createdAt;

    private static final long serialVersionUID = 1L;
}