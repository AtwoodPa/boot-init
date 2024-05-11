package com.pp.boot.mapper;

import com.pp.boot.domain.TCourseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (t_course)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-09 13:42:17
 */
public interface TCourseMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param courseId 主键
     * @return 实例对象
     */
    TCourseEntity selectByPrimaryKey(Integer courseId);

    /**
     * 统计总行数
     *
     * @param tCourseEntity 查询条件
     * @return 总行数
     */
    long count(TCourseEntity tCourseEntity);

    /**
     * 新增数据
     *
     * @param tCourseEntity 实例对象
     * @return 影响行数
     */
    int insert(TCourseEntity tCourseEntity);


    /**
     * 新增数据
     *
     * @param tCourseEntity 实例对象
     * @return 影响行数
     */
    int insertSelective(TCourseEntity tCourseEntity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCourseEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TCourseEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCourseEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TCourseEntity> entities);

    /**
     * 修改数据
     *
     * @param tCourseEntity 实例对象
     * @return 影响行数
     */
    int update(TCourseEntity tCourseEntity);

    /**
     * 通过主键删除数据
     *
     * @param courseId 主键
     * @return 影响行数
     */
    int deleteById(Integer courseId);

}

