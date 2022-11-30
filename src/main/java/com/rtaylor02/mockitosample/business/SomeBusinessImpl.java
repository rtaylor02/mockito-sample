package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.SomeDataService;

public class SomeBusinessImpl {
    private SomeDataService service;

    public SomeDataService getService() {
        return service;
    }

    public void setService(SomeDataService service) {
        this.service = service;
    }

    public int sum(int[] array) {
        int result = 0;

        for(int i : array) {
            result += i;
        }

        return result;
    }

    public int sum_usingSomeDataService() {
        int[] array = service.retriveAllData();
        int result = 0;

        for(int i : array) {
            result += i;
        }

        return result;
    }
}
