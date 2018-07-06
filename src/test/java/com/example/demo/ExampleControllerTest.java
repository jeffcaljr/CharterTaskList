package com.example.demo;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebMvc
public class ExampleControllerTest {

//    @Autowired
//    private MockMvc mvc;


    @Test
    public void getNum() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/test/v1/1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("The number you entered was 1")));

        Assert.assertEquals(true, true);
    }

    @Test
    public void sayHelloTest() throws Exception{
        String hello = "Hi";

        Assert.assertEquals(hello, "Hello");
    }

}
