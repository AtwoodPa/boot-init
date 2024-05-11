package com.pp.boot.mapper;

import com.pp.boot.domain.TStudentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (t_student)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-09 13:42:19
 */
public interface TStudentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    TStudentEntity selectByPrimaryKey(Integer studentId);

    /**
     * 统计总行数
     *
     * @param tStudentEntity 查询条件
     * @return 总行数
     */
    long count(TStudentEntity tStudentEntity);

    /**
     * 新增数据
     *
     * @param tStudentEntity 实例对象
     * @return 影响行数
     */
    int insert(TStudentEntity tStudentEntity);


    /**
     * 新增数据
     *
     * @param tStudentEntity 实例对象
     * @return 影响行数
     */
    int insertSelective(TStudentEntity tStudentEntity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStudentEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TStudentEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStudentEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TStudentEntity> entities);

    /**
     * 修改数据
     *
     * @param tStudentEntity 实例对象
     * @return 影响行数
     */
    int update(TStudentEntity tStudentEntity);

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 影响行数
     */
    int deleteById(Integer studentId);

}

