package com.pp.boot.controller.student;

import com.pp.boot.domain.TestDataEntity;
import com.pp.boot.service.TestDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestData)表控制层
 *
 * @author makejava
 * @since 2024-05-09 13:42:16
 */
@RestController
@RequestMapping("testDataEntity")
public class TestDataController {
    /**
     * 服务对象
     */
    @Resource
    private TestDataService testDataService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TestDataEntity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.testDataService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param testDataEntity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TestDataEntity> add(TestDataEntity testDataEntity) {
        return ResponseEntity.ok(this.testDataService.insert(testDataEntity));
    }

    /**
     * 编辑数据
     *
     * @param testDataEntity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TestDataEntity> edit(TestDataEntity testDataEntity) {
        return ResponseEntity.ok(this.testDataService.update(testDataEntity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.testDataService.deleteById(id));
    }

}

