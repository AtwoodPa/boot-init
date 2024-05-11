package com.pp.boot.service;

import com.pp.boot.domain.TCourseEntity;
import com.pp.boot.mapper.TCourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TCourse)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 13:42:18
 */
@Service("tCourseService")
public class TCourseService {
    @Resource
    private TCourseMapper tCourseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param courseId 主键
     * @return 实例对象
     */
    public TCourseEntity queryById(Integer courseId) {
        return this.tCourseMapper.selectByPrimaryKey(courseId);
    }

    /**
     * 新增数据
     *
     * @param tCourseEntity 实例对象
     * @return 实例对象
     */
    public TCourseEntity insert(TCourseEntity tCourseEntity) {
        this.tCourseMapper.insert(tCourseEntity);
        return tCourseEntity;
    }

    /**
     * 修改数据
     *
     * @param tCourseEntity 实例对象
     * @return 实例对象
     */
    public TCourseEntity update(TCourseEntity tCourseEntity) {
        this.tCourseMapper.update(tCourseEntity);
        return this.queryById(tCourseEntity.getCourseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param courseId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer courseId) {
        return this.tCourseMapper.deleteById(courseId) > 0;
    }
}

