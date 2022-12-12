package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.SomeDataService;

import java.util.Arrays;

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

    public int calculateSum(int[] data) {
        /*
        Java Stream API is used here.
        Arrays.stream(data) returns a stream of data, e.g. 1, 2, 3, etc of type IntStream.
        IntStream instance method reduce takes an IntBinaryOperator that acts as a method reference using :: operator
        which then returns an OptionalInt.
        .orElse specifies that it returns, either the value of Integer.sum of the stream, or 0.
         */
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int sum_usingSomeDataService() {
        int[] array = service.retriveAllData();
        int result = 0;

        for(int i : array) {
            result += i;
        }

        return result;
    }

    /*
    Like calculateSum, calculateSum_usingSomeDataService() uses Java Stream API to do the same operation as
    sum_usingSomeDataService in a more efficient way.
     */
    public int calculateSum_usingSomeDataService() {
        int[] array = service.retriveAllData();

        return Arrays.stream(array).reduce(Integer::sum).orElse(0);
    }
}
