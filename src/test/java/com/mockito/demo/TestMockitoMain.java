package com.mockito.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * @author dbabii
 */
public class TestMockitoMain {

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @Test
    public void iteratorWillReturnHelloWorld() {

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");

        String result = i.next() + " " + i.next();

        assertEquals("Hello World", result);
    }

    @Test
    public void withArgs() {

        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1, c.compareTo("Test"));
    }

    @Test
    public void withUnspecifiedArgs() {

        Comparable c = mock(Comparable.class);
        when(c.compareTo(1)).thenReturn(-1);
        assertEquals(-1, c.compareTo(5));
    }

    @Test(expected = IOException.class)
    public void throwsAnException() throws IOException {

        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        doThrow(new IOException()).when(mock).close();
        osw.close();
    }

    @Test
    public void mockList() {

        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void mockLinkedList() {

        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");

        System.out.println(mockedList.get(0));

        System.out.println(mockedList.get(999));
    }

    @Test
    public void spyVerification() {

        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));
        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }
}
