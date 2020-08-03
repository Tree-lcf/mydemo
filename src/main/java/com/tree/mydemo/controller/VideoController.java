package com.tree.mydemo.controller;

import com.tree.mydemo.domain.Video;
import com.tree.mydemo.service.VideoService;
import com.tree.mydemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public JsonData list(){

        List<Video> list = videoService.videoList();
        return JsonData.buildSuccess(list);
    }

    @PostMapping("save")
    public JsonData saveVideo(@RequestBody Video video){

        System.out.println("video");
        return JsonData.buildSuccess(video);

    }
}
