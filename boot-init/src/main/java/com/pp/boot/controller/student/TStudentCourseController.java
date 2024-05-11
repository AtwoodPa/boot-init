package com.pp.boot.controller.student;

import com.pp.boot.domain.TStudentCourseEntity;
import com.pp.boot.service.TStudentCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStudentCourse)表控制层
 *
 * @author makejava
 * @since 2024-05-09 13:42:20
 */
@RestController
@RequestMapping("tStudentCourseEntity")
public class TStudentCourseController {
    /**
     * 服务对象
     */
    @Resource
    private TStudentCourseService tStudentCourseService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TStudentCourseEntity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tStudentCourseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tStudentCourseEntity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TStudentCourseEntity> add(TStudentCourseEntity tStudentCourseEntity) {
        return ResponseEntity.ok(this.tStudentCourseService.insert(tStudentCourseEntity));
    }

    /**
     * 编辑数据
     *
     * @param tStudentCourseEntity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TStudentCourseEntity> edit(TStudentCourseEntity tStudentCourseEntity) {
        return ResponseEntity.ok(this.tStudentCourseService.update(tStudentCourseEntity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tStudentCourseService.deleteById(id));
    }

}

