package com.tree.mydemo.controller;

import com.tree.mydemo.config.DemoConfig;
import com.tree.mydemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pub/config")
public class TestController {


    @Autowired
    private DemoConfig demoConfig;

    @GetMapping("get")
    public JsonData getConfig(){

        Map<String,String> map = new HashMap<>();
        map.put("appid", demoConfig.getAppid());
        map.put("appsec", demoConfig.getAppsec());

        return JsonData.buildSuccess(map);

    }

    @GetMapping("list")
    public JsonData getExc(){
        int i = 1/0;

        return JsonData.buildSuccess("");
    }
}
