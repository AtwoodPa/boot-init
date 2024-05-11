package com.pp.boot.service;

import com.pp.boot.domain.TStudentCourseEntity;
import com.pp.boot.mapper.TStudentCourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TStudentCourse)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 13:42:20
 */
@Service("tStudentCourseService")
public class TStudentCourseService {
    @Resource
    private TStudentCourseMapper tStudentCourseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TStudentCourseEntity queryById(Integer id) {
        return this.tStudentCourseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *
     * @param tStudentCourseEntity 实例对象
     * @return 实例对象
     */
    public TStudentCourseEntity insert(TStudentCourseEntity tStudentCourseEntity) {
        this.tStudentCourseMapper.insert(tStudentCourseEntity);
        return tStudentCourseEntity;
    }

    /**
     * 修改数据
     *
     * @param tStudentCourseEntity 实例对象
     * @return 实例对象
     */
    public TStudentCourseEntity update(TStudentCourseEntity tStudentCourseEntity) {
        this.tStudentCourseMapper.update(tStudentCourseEntity);
        return this.queryById(tStudentCourseEntity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.tStudentCourseMapper.deleteById(id) > 0;
    }
}

