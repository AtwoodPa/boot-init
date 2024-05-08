package com.pp.boot.mapper;

import com.pp.boot.domain.TestData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestData record);

    int insertSelective(TestData record);

    TestData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestData record);

    int updateByPrimaryKey(TestData record);

    List<TestData> findAll();

}