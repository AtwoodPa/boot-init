package com.pp.boot.mapper;

import com.pp.boot.domain.TestDataEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (test_data)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-09 13:42:16
 */
public interface TestDataMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestDataEntity selectByPrimaryKey(Integer id);

    /**
     * 统计总行数
     *
     * @param testDataEntity 查询条件
     * @return 总行数
     */
    long count(TestDataEntity testDataEntity);

    /**
     * 新增数据
     *
     * @param testDataEntity 实例对象
     * @return 影响行数
     */
    int insert(TestDataEntity testDataEntity);


    /**
     * 新增数据
     *
     * @param testDataEntity 实例对象
     * @return 影响行数
     */
    int insertSelective(TestDataEntity testDataEntity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestDataEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TestDataEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TestDataEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TestDataEntity> entities);

    /**
     * 修改数据
     *
     * @param testDataEntity 实例对象
     * @return 影响行数
     */
    int update(TestDataEntity testDataEntity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

