package com.rtaylor02.mockitosample.business;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class SpyTest {
    /*
    With spy (instead of mock), the original behaviour of the class/interface is retained.
    You can stub(override) and verify specific behaviour(methods) on spy.
     */
    @Test
    void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("1st member"); // This actually adds it to the spy
        System.out.println(arrayListSpy.size()); // 1
        System.out.println(arrayListSpy.get(0)); // "1st member"

        arrayListSpy.add("2nd member");
        System.out.println(arrayListSpy.size()); // 2

        when(arrayListSpy.size()).thenReturn(5); // Overrides the original behaviour
        System.out.println(arrayListSpy.size()); // 5

        //verify(arrayListSpy).add("3rd member"); // failed - add() with "3rd member" arg is never called
        verify(arrayListSpy).add("1st member"); // pass - add() with "1st member" arg is called once


    }

}
