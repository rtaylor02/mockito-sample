package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SomeBusinessMockTest {

    @Test
    void sum_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService serviceMock = mock(SomeDataService.class);
        when(serviceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});

        business.setService(serviceMock);

        int actual = business.sum_usingSomeDataService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void sum_empty_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService serviceMock = mock(SomeDataService.class);
        when(serviceMock.retriveAllData()).thenReturn(new int[]{});

        business.setService(serviceMock);

        int actual = business.sum_usingSomeDataService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void sum_one_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        SomeDataService serviceMock = mock(SomeDataService.class);
        when(serviceMock.retriveAllData()).thenReturn(new int[]{3});

        business.setService(serviceMock);

        int actual = business.sum_usingSomeDataService();
        int expected = 3;
        assertEquals(expected, actual);
    }
}