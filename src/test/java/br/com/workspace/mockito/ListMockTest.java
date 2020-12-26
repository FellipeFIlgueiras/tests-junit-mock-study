package br.com.workspace.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    @Test
    public void testSize() {
        var mockList = mock(List.class);
        when(mockList.size()).thenReturn(10);
        assertEquals(10, mockList.size());
    }

    @Test
    public void testSizeMultipleReturns() {
        var mockList = mock(List.class);
        when(mockList.size()).thenReturn(10).thenReturn(20).thenReturn(30);
        assertEquals(10, mockList.size());
        assertEquals(20, mockList.size());
        assertEquals(30, mockList.size());
        assertEquals(30, mockList.size());
    }

    @Test
    public void testGetSpecificParameter() {
        var mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Parameter");
        assertEquals("Parameter", mockList.get(0));
        assertNull(mockList.get(1));
    }

    @Test
    public void testGetGenericParameter() {
        var mockList = mock(List.class);
        when(mockList.get(Mockito.anyInt())).thenReturn("Parameter");
        assertEquals("Parameter", mockList.get(0));
        assertEquals("Parameter", mockList.get(1));
        assertEquals("Parameter", mockList.get(2));
    }

}
