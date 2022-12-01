package com.rtaylor02.mockitosample.business;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class SpyTest {
    @Test
    void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("1st member"); // This actually adds it to the spy
        System.out.println(arrayListSpy.size()); // 1
        System.out.println(arrayListSpy.get(0)); // "1st member"

        when(arrayListSpy.size()).thenReturn(5); // Override the original behaviour
        System.out.println(arrayListSpy.size()); // 5

        //verify(arrayListSpy).add("2nd member"); // failed
        verify(arrayListSpy).add("1st member"); // pass
    }

}
