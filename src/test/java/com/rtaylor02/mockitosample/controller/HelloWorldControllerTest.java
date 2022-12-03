package com.rtaylor02.mockitosample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /*
    We want to test calling GET "/hello-world". We expect the response would be in JSON format.
    We expect the response would be "Hello world, Rod!!" as content and OK as status.
     */
    @Test
    void helloWorld_basic() throws Exception {
        // We need to build a request first
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        // Test the response
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World, Rod!!"))
                .andReturn();
        
        assertEquals("Hello World, Rod!!", result.getResponse().getContentAsString());
    }
}
