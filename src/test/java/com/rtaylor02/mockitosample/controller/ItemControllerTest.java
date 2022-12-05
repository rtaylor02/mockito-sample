package com.rtaylor02.mockitosample.controller;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
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

        /*
        NOTE:
        1) .andExpect(content().string() will expect the result to be the same to the tee
        2) .andExpect(content().json() instead to check partial result.
            NOTE:
            - curly braces must be included!!
            - spaces are ignored.
        3) JSONAssert.assertEquals(expected, actual, strict) is easier to read because:
            NOTE:
            - strict: true
                - spaces are ignored
                - all elements must be there.
            - strict: false
                - spaces are ignored
                - partial elements are ok
                - no need for escape characters \"

         */
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())

//                .andExpect(content().string(
//                        "{" +
//                        "\"id\":1," +
//                        "\"name\":\"Ball\"," +
//                        "\"price\":5," +
//                        "\"quantity\":100" +
//                        "}"))

//                .andExpect(content().string("id: 1, name: \"Ball\""))

//                .andExpect(content().json(
//                        "{" +
//                        "\"name\":\"Ball\"" +
//                        "}"))

                .andReturn();

//        JSONAssert.assertEquals(
//                "{id: 1,name:Ball}",
//                result.getResponse().getContentAsString(),
//                true); // failed

        JSONAssert.assertEquals("{id:1,name:Ball,price:5,quantity:100}",
                result.getResponse().getContentAsString(),
                true); // pass

        JSONAssert.assertEquals(
                "{id: 1,name:Ball}",
                result.getResponse().getContentAsString(),
                false); // pass
    }
}
