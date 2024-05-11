package com.pp.boot.mapper;

import com.pp.boot.domain.TStudentCourseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (t_student_course)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-09 13:42:20
 */
public interface TStudentCourseMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TStudentCourseEntity selectByPrimaryKey(Integer id);

    /**
     * 统计总行数
     *
     * @param tStudentCourseEntity 查询条件
     * @return 总行数
     */
    long count(TStudentCourseEntity tStudentCourseEntity);

    /**
     * 新增数据
     *
     * @param tStudentCourseEntity 实例对象
     * @return 影响行数
     */
    int insert(TStudentCourseEntity tStudentCourseEntity);


    /**
     * 新增数据
     *
     * @param tStudentCourseEntity 实例对象
     * @return 影响行数
     */
    int insertSelective(TStudentCourseEntity tStudentCourseEntity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStudentCourseEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TStudentCourseEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TStudentCourseEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TStudentCourseEntity> entities);

    /**
     * 修改数据
     *
     * @param tStudentCourseEntity 实例对象
     * @return 影响行数
     */
    int update(TStudentCourseEntity tStudentCourseEntity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

