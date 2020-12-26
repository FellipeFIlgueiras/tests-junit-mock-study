package br.com.workspace.mockito;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import br.com.workspace.mockito.demo.DataService;
import br.com.workspace.mockito.demo.SomeBusinessImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessTest {

    @Mock
    DataService dataService;

    @InjectMocks
    SomeBusinessImpl business;

    @Test
    public void testFindGreatestFromAllData() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {24, 15, 3});
        assertEquals(24, business.findTheGreatestFromAllData());
    }

    @Test
    public void testFindGreatestFromAllDataWithOneValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {15});
        assertEquals(15, business.findTheGreatestFromAllData());
    }

    @Test
    public void testFindGreatestFromAllDataWithNoValue() {
        when(dataService.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }

}
