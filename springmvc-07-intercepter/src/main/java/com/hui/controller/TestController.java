package com.hui.controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/t1")
    public String test(){
        System.out.println("执行了");
        return "OK";
    }

}
