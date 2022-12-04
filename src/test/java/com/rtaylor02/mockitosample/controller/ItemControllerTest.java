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

@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test // Here you will test the content of the dummy item returned from the ItemController
    void getDummyItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        // .andExpect(content().string() will expect the result to be the same to the tee
        // use .andExpect(content().json() instead to check partial result
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
//                .andExpect(content().string("{\n" +
//                        "id: 1,\n" +
//                        "name: \"Ball\",\n" +
//                        "price: 5,\n" +
//                        "quantity: 100\n" +
//                        "}"))
                .andExpect(content().string("id: 1, name: \"Ball\""))
                .andReturn();
    }
}
