package com.tree.mydemo;

import com.tree.mydemo.domain.Video;
import com.tree.mydemo.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MydemoApplication.class})
@AutoConfigureMockMvc
public class VideoTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/config/get"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();

        System.out.println(contentAsString);
    }

    @Before
    public void testOne(){
        System.out.println("before");
    }

    @Test
    public void testTwo(){
        List<Video> list = videoService.videoList();

        TestCase.assertTrue(list.size()>0);
    }

    @After
    public void testThree(){
        System.out.println("after");
    }

}
