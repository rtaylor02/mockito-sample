package com.rtaylor02.mockitosample.learning;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONPathTest {
    @Test
    void learning() {
        String responseFromService =
                "[" +
                "{\"id\":10000, \"name\":\"Pencil\", \"quantity\": 5}," +
                "{\"id\":10001, \"name\":\"Pen\", \"quantity\": 15}," +
                "{\"id\":10002, \"name\":\"Colour pencil\", \"quantity\": 25}" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);

        // Test the length of the JSON array object
        // $. is JSON path for root directory, in this case the array
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        // Test the individual object - read the id element of the objects
        // $.. is JSON path for 1 level below root directory, in this case the individual object
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(10000, 10001, 10002);

        // Test the individual object - read the id element of the objects
        // $.[1] is JSON path for 1st element of the objects in the root level
        // $.[0:1] is JSON path for 1st & 2nd elements of the objects in the root level
        // $.[?(@.name=='colour pencil' )] is JSON path for any elements that has attribute of name of 'colour pencil'
        // $.[?(@.quantity==15 )] is JSON path for any elements that has attribute of quantity of 15
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString());
        System.out.println(context.read("$.[?(@.name=='colour pencil' )]").toString());
        System.out.println(context.read("$.[?(@.quantity==15 )]").toString());
    }


}
