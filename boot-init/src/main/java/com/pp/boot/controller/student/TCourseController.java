package com.pp.boot.controller.student;

import com.pp.boot.domain.TCourseEntity;
import com.pp.boot.service.TCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TCourse)表控制层
 *
 * @author makejava
 * @since 2024-05-09 13:42:17
 */
@RestController
@RequestMapping("tCourseEntity")
public class TCourseController {
    /**
     * 服务对象
     */
    @Resource
    private TCourseService tCourseService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TCourseEntity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tCourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tCourseEntity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TCourseEntity> add(TCourseEntity tCourseEntity) {
        return ResponseEntity.ok(this.tCourseService.insert(tCourseEntity));
    }

    /**
     * 编辑数据
     *
     * @param tCourseEntity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TCourseEntity> edit(TCourseEntity tCourseEntity) {
        return ResponseEntity.ok(this.tCourseService.update(tCourseEntity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tCourseService.deleteById(id));
    }

}

