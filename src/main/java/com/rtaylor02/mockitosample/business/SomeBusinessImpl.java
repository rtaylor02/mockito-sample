package com.rtaylor02.mockitosample.business;

public class SomeBusinessImpl {
    public int sum(int[] array) {
        int result = 0;
        for(int i : array) {
            result += i;
        }
        return result;
    }
}
