package com.geek.structure.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 测试
 * @author: yxb
 * @since: 2019-11-29 14:50
 */
@RestController
@RequestMapping(value = "/test")
public class DemoController {

    @GetMapping(value = "/d/{name}/{id}")
    public Map demo(@PathVariable String name, @PathVariable Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("id", id);

        return params;
    }

    @GetMapping(value = "/d1")
    public String demo(@RequestParam (value = "name") String name) {

        return "name is : "+ name;
    }
}
