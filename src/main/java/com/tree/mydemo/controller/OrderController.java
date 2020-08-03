package com.tree.mydemo.controller;

import com.tree.mydemo.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pri/order")
public class OrderController {

    @RequestMapping("save")
    public JsonData saveOrder(){

        return JsonData.buildSuccess("下单成功");

    }
}
