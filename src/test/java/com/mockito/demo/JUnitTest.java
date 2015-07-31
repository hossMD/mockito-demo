package com.mockito.demo;

import org.junit.*;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JUnitTest {

    public JUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void iteratorWillReturnHelloWorld() {

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");

        String result = i.next() + " " + i.next();

        assertEquals("Hello World", result);
    }
}
