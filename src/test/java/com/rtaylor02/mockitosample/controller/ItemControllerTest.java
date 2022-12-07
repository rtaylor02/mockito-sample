package com.rtaylor02.mockitosample.controller;

import com.rtaylor02.mockitosample.business.ItemBusinessService;
import com.rtaylor02.mockitosample.model.Item;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class) // Tells the application to load ItemController bean ONLY (dependencies NOT included)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean // Required to mock beans other than that loaded by @WebMvcTest annotation
    private ItemBusinessService businessService;

    @Test // Here you will test the content of the dummy item returned from the ItemController
    void getDummyItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        /*
        NOTE:
        1) .andExpect(content().string() will expect the result to be the same to the tee
        2) .andExpect(content().json() - use this instead!
            NOTE:
            - partial elements are ok
            - spaces are ignored.
            - curly braces must be included!!

        The backbone of content().json() is JSONAssert.assertEquals(expected, actual, strict):
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

//                .andExpect(content().string("id: 1, name: \"Ball\"")) // fail - not complete, there is space

                .andExpect(content().json("{id:1, name:Ball}")) // pass

                .andReturn();

//        JSONAssert.assertEquals(
//                "{id: 1,name:Ball}",
//                result.getResponse().getContentAsString(),
//                true); // failed

//        JSONAssert.assertEquals("{id:1,name:Ball,price:5,quantity:100}",
//                result.getResponse().getContentAsString(),
//                true); // pass

//        JSONAssert.assertEquals(
//                "{id: 1,name:Ball}",
//                result.getResponse().getContentAsString(),
//                false); // pass
    }

    @Test
    void getItemFromBusinessService() throws Exception {
        // Mock the behaviour of businessService
        when(businessService.retrieveHardCodedItem())
                .thenReturn(new Item(2, "Ball 2", 50, 20));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{ id:2, name: \"Ball 2\" }"))
                .andReturn();
    }

    @Test
    void getAllItemsFromDb() throws Exception{
        // Mock the behaviour of businessService
        when(businessService.retrieveAllItems())
                .thenReturn(Arrays.asList(
                        new Item(2, "Ball 2", 50, 20),
                        new Item(3, "Ball 3", 22, 30)
                ));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // Note for json: array of JSON as mocked above
                // - Number of elements in the array must matched as mocked above
                // - elements of the item can even be empty, i.e. { } - not checked to the tee
                .andExpect(content().json("[{ id:2, name: \"Ball 2\" }, { id:3, name: \"Ball 3\", price: 22 }]"))
                .andReturn();
    }
}
