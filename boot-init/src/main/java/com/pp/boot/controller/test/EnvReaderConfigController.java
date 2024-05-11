package com.pp.boot.controller.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author supanpan
 * @create 2024/05/08 16:45
 */
@RequestMapping("/env")
@RestController
@RequiredArgsConstructor
public class EnvReaderConfigController {

    private final Environment env;

    @Value("${panpan.name}")
    private String name;

    @GetMapping("/reader")
    public Map<String,String> reader() {
        HashMap<String, String> map = new HashMap<>();
        map.put("panpan.name",env.getProperty("panpan.name"));
        map.put("panpan.age", Arrays.toString(env.getDefaultProfiles()));
        return map;
    }

}
