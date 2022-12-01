package com.rtaylor02.mockitosample.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List mock = Mockito.mock(List.class);

    @Test
    void size_basic() {
        when(mock.size()).thenReturn(2);
        assertEquals(2,mock.size());
    }

    @Test
    void multipleCalls() {
        when(mock.size()).thenReturn(2).thenReturn(5);
        assertEquals(2, mock.size());
        assertEquals(5, mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("Rod Taylor");
        assertEquals("Rod Taylor", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Rod Taylor"); // anyInt() as generic parameter
        assertEquals("Rod Taylor", mock.get(0));
        assertEquals("Rod Taylor", mock.get(1));
    }

    @Test // This is to verify that certain methods in a mock is invoked
    void invocationVerification() {
        // SUT
        // Deliberate invocation to create the scenario where a mock's methods are called
        mock.get(0);
        mock.get(1);

        verify(mock).get(0);

        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test // This is to test if a certain argument is supplied for a mock's method invocation
    void argumentCapturing() {
        // SUT
        // Deliberate invocation to create the scenario where a mock's methods are called
        mock.get(0);

        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        verify(mock).get(captor.capture()); // Official recommendation: only capture() only with verify()

        assertEquals(0, captor.getValue());
    }

    @Test // This is to test if a certain argument is supplied for a mock's method invocation
    void argumentCapturing2() {
        // SUT
        // Deliberate invocation to create the scenario where a mock's methods are called
        mock.add("Adam");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock).add(captor.capture()); // Official recommendation: only capture() only with verify()

        assertEquals("Adam", captor.getValue());
    }

    @Test // This is to test if a certain argument is supplied for a mock's method invocation
    void multipleArgumentCapturing() {
        // SUT
        // Deliberate invocation to create the scenario where a mock's methods are called
        mock.add("Adam");
        mock.add("Kasia");

        ArgumentCaptor<Object> captor = ArgumentCaptor.forClass(Object.class);

        verify(mock, times(2)).add(captor.capture()); // Official recommendation: only capture() only with verify()

        List allArguments = captor.getAllValues();
        assertEquals("Adam", allArguments.get(0));
        assertEquals("Kasia", allArguments.get(1));
    }


}
