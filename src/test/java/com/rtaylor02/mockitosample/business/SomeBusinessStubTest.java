package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{3};
    }
}

class SomeBusinessStubTest {

    @Test
    void sum_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setService(new SomeDataServiceStub());
        int actual = business.sum_usingSomeDataService();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void sum_empty_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setService(new SomeDataServiceEmptyStub());
        int actual = business.sum_usingSomeDataService();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void sum_one_usingSomeDataService() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setService(new SomeDataServiceOneElementStub());
        int actual = business.sum_usingSomeDataService();
        int expected = 3;
        assertEquals(expected, actual);
    }
}