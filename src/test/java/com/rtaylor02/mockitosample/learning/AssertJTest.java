package com.rtaylor02.mockitosample.learning;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
    @Test
    void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers)
                .hasSize(3)
                .contains(12,45)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);
    }

    @Test
    void learningWithString() {
        String actual = "";
        assertThat(actual).isEmpty();

        actual = "ABCDE";
        assertThat(actual)
                .contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");

    }
}
