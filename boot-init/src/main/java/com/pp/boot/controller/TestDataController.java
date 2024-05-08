package com.pp.boot.controller;

import com.pp.boot.domain.TestData;
import com.pp.boot.mapper.TestDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author supanpan
 * @create 2024/05/08 17:31
 */
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestDataController {

    private final  TestDataMapper mapper;

    @GetMapping("/allData")
    public List<TestData> getAllData() {
        return mapper.findAll();
    }
}
