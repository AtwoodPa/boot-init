package com.pp.boot.controller.student;

import com.pp.boot.domain.TGradeEntity;
import com.pp.boot.service.TGradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TGrade)表控制层
 *
 * @author makejava
 * @since 2024-05-09 13:42:18
 */
@RestController
@RequestMapping("tGradeEntity")
public class TGradeController {
    /**
     * 服务对象
     */
    @Resource
    private TGradeService tGradeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TGradeEntity> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tGradeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tGradeEntity 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TGradeEntity> add(TGradeEntity tGradeEntity) {
        return ResponseEntity.ok(this.tGradeService.insert(tGradeEntity));
    }

    /**
     * 编辑数据
     *
     * @param tGradeEntity 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TGradeEntity> edit(TGradeEntity tGradeEntity) {
        return ResponseEntity.ok(this.tGradeService.update(tGradeEntity));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tGradeService.deleteById(id));
    }

}

