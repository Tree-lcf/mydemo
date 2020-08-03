package com.tree.mydemo.service.impl;

import com.tree.mydemo.domain.Video;
import com.tree.mydemo.mapper.VideoMapper;
import com.tree.mydemo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> videoList() {
        return videoMapper.videoList();
    }
}
