package com.pp.boot.service;

import com.pp.boot.domain.TestDataEntity;
import com.pp.boot.mapper.TestDataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TestData)表服务实现类
 *
 * @author makejava
 * @since 2024-05-09 13:42:17
 */
@Service("testDataService")
public class TestDataService {
    @Resource
    private TestDataMapper testDataMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TestDataEntity queryById(Integer id) {
        return this.testDataMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增数据
     *
     * @param testDataEntity 实例对象
     * @return 实例对象
     */
    public TestDataEntity insert(TestDataEntity testDataEntity) {
        this.testDataMapper.insert(testDataEntity);
        return testDataEntity;
    }

    /**
     * 修改数据
     *
     * @param testDataEntity 实例对象
     * @return 实例对象
     */
    public TestDataEntity update(TestDataEntity testDataEntity) {
        this.testDataMapper.update(testDataEntity);
        return this.queryById(testDataEntity.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.testDataMapper.deleteById(id) > 0;
    }
}

