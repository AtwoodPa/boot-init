package com.pp.boot.mapper;

import com.pp.boot.domain.TGradeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (t_grade)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-09 13:42:18
 */
public interface TGradeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param gradeId 主键
     * @return 实例对象
     */
    TGradeEntity selectByPrimaryKey(Integer gradeId);

    /**
     * 统计总行数
     *
     * @param tGradeEntity 查询条件
     * @return 总行数
     */
    long count(TGradeEntity tGradeEntity);

    /**
     * 新增数据
     *
     * @param tGradeEntity 实例对象
     * @return 影响行数
     */
    int insert(TGradeEntity tGradeEntity);


    /**
     * 新增数据
     *
     * @param tGradeEntity 实例对象
     * @return 影响行数
     */
    int insertSelective(TGradeEntity tGradeEntity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGradeEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TGradeEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TGradeEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TGradeEntity> entities);

    /**
     * 修改数据
     *
     * @param tGradeEntity 实例对象
     * @return 影响行数
     */
    int update(TGradeEntity tGradeEntity);

    /**
     * 通过主键删除数据
     *
     * @param gradeId 主键
     * @return 影响行数
     */
    int deleteById(Integer gradeId);

}

