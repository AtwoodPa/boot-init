package com.pp.boot.service;

import com.pp.boot.domain.TGradeEntity;
import com.pp.boot.mapper.TGradeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TGrade)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 13:42:19
 */
@Service("tGradeService")
public class TGradeService {
    @Resource
    private TGradeMapper tGradeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param gradeId 主键
     * @return 实例对象
     */
    public TGradeEntity queryById(Integer gradeId) {
        return this.tGradeMapper.selectByPrimaryKey(gradeId);
    }

    /**
     * 新增数据
     *
     * @param tGradeEntity 实例对象
     * @return 实例对象
     */
    public TGradeEntity insert(TGradeEntity tGradeEntity) {
        this.tGradeMapper.insert(tGradeEntity);
        return tGradeEntity;
    }

    /**
     * 修改数据
     *
     * @param tGradeEntity 实例对象
     * @return 实例对象
     */
    public TGradeEntity update(TGradeEntity tGradeEntity) {
        this.tGradeMapper.update(tGradeEntity);
        return this.queryById(tGradeEntity.getGradeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param gradeId 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer gradeId) {
        return this.tGradeMapper.deleteById(gradeId) > 0;
    }
}

