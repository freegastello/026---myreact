package com.myreact.reacttest.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicNumberTest {
    @Test
    public void bumTest() {
        System.out.println(MagicNumber.int_1);
        assertEquals(1, MagicNumber.int_1);
    }
}
