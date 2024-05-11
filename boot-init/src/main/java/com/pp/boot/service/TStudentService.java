package com.pp.boot.service;

import com.pp.boot.domain.TStudentEntity;
import com.pp.boot.mapper.TStudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TStudent)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 13:42:20
 */
@Service("tStudentService")
public class TStudentService {
    @Resource
    private TStudentMapper tStudentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    public TStudentEntity queryById(Integer studentId) {
        return this.tStudentMapper.selectByPrimaryKey(studentId);
    }

    /**
     * 新增数据
     *
     * @param tStudentEntity 实例对象
     * @return 实例对象
     */
    public TStudentEntity insert(TStudentEntity tStudentEntity) {
        this.tStudentMapper.insert(tStudentEntity);
        return tStudentEntity;
    }

    /**
     * 修改数据
     *
     * @param tStudentEntity 实例对象
     * @return 实例对象
     */
    public TStudentEntity update(TStudentEntity tStudentEntity) {
        this.tStudentMapper.update(tStudentEntity);
        return this.queryById(tStudentEntity.getStudentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer studentId) {
        return this.tStudentMapper.deleteById(studentId) > 0;
    }
}

