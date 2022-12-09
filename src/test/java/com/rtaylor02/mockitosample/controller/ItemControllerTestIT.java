package com.rtaylor02.mockitosample.controller;

import com.rtaylor02.mockitosample.business.ItemBusinessService;
import com.rtaylor02.mockitosample.model.Item;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
@SpringBootTest: looks for classes in this package and its parents that has @SpringBootApplication.
It will then run the MockitoSampleApplication.java and run SB as normal app.

WebEnvironment.RANDOM_PORT: allows any port to be used for test. This is good for Continuous Integration test that
can be from any port.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTestIT {
    /*
    TestRestTemplate: allows this class to call a service in the actual application.
    TestRestTemplate bean is already created when application is running. Therefore, we just need to autowire it.
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test // Call a service and test the response
    void contextLoads() throws JSONException {
        // Act
        String response = this.testRestTemplate.getForObject("/all-items-from-database", String.class);

        // Assert
        JSONAssert.assertEquals(
                "[{id:1, name: \"Ball 1\"}, " +
                        "{id:2, name: \"Ball 2\"}, " +
                        "{id:3, name: \"Ball 3\"}]"
                , response
                , false);
    }
}
