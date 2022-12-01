package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class) // Needed to use with @InjectMocks and @Mock
class SomeBusinessMockTest {
    // Red - Green - Refactor
    // Arrange - Act - Assert

    /* WITHOUT @InjectMocks and @Mock
    ==================================
    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService serviceMock = mock(SomeDataService.class);

    @BeforeEach
    void beforeEachTest() {
        business.setService(serviceMock);
    }
    ==================================
     */

    @InjectMocks
    SomeBusinessImpl business;
    @Mock
    SomeDataService serviceMock;

    @Test
    void sum_usingSomeDataService() {
        when(serviceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, business.sum_usingSomeDataService());
    }

    @Test
    void sum_empty_usingSomeDataService() {
        when(serviceMock.retriveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.sum_usingSomeDataService());
    }

    @Test
    void sum_one_usingSomeDataService() {
        when(serviceMock.retriveAllData()).thenReturn(new int[]{3});
        assertEquals(3, business.sum_usingSomeDataService());
    }
}