package com.rtaylor02.mockitosample.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    void sum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.sum(new int[] {1, 2, 3});
        int expected = 6;
        assertEquals(expected, result);
    }

    @Test
    void sum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.sum(new int[] {});
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void sum_one() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.sum(new int[] {3});
        int expected = 3;
        assertEquals(expected, result);
    }
}