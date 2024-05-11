package com.pp.boot.controller.student;

import com.pp.boot.common.core.domain.Result;
import com.pp.boot.domain.TStudentEntity;
import com.pp.boot.service.TStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStudent)表控制层
 *
 * @author makejava
 * @since 2024-05-09 13:42:19
 */
@RestController
@RequestMapping("tStudentEntity")
public class TStudentController {
    /**
     * 服务对象
     */
    @Resource
    private TStudentService tStudentService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result<TStudentEntity> queryById(@PathVariable("id") Integer id) {
        return Result.ok(this.tStudentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tStudentEntity 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<TStudentEntity> add(TStudentEntity tStudentEntity) {
        return Result.ok(this.tStudentService.insert(tStudentEntity));
    }

    /**
     * 编辑数据
     *
     * @param tStudentEntity 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result<TStudentEntity> edit(TStudentEntity tStudentEntity) {
        return Result.ok(this.tStudentService.update(tStudentEntity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result<Boolean> deleteById(Integer id) {
        return Result.ok(this.tStudentService.deleteById(id));
    }

}

