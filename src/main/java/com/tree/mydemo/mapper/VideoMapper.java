package com.tree.mydemo.mapper;

import com.tree.mydemo.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1,new Video(1,"基础课1"));
        videoMap.put(2,new Video(2,"基础课2"));
        videoMap.put(3,new Video(3,"基础课3"));
        videoMap.put(4,new Video(4,"基础课4"));
        videoMap.put(5,new Video(5,"基础课5"));
    }

    public List<Video> videoList(){

        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());

        return list;
    }


}
