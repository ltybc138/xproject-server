package com.ltybc.xproject.server.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void generateTag_worksCorrectly() throws Exception {
        String s1 = "Accessories";
        assertEquals("accessories", Utils.generateTag(s1));
        String s2 = "Computers and Laptops";
        assertEquals("computers-and-laptops", Utils.generateTag(s2));
    }
}
