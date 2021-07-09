package com.yangdq.java.algorithm.fouth.fundamentals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    private Bag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new Bag<>();
    }

    @AfterEach
    void tearDown() {
        bag = null;
    }

    @Test
    void add() {
        assertEquals(0, bag.size());

        bag.add("hello");
        assertEquals(1, bag.size());

        bag.add("world");
        assertEquals(2, bag.size());
    }

    @Test
    void isEmpty() {
        assertTrue(bag.isEmpty());

        bag.add("hello");
        assertFalse(bag.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, bag.size());

        bag.add("hello");
        assertEquals(1, bag.size());
    }

    @Test
    void iterator() {
        String hello = "hello";
        String world = "world";
        bag.add(hello);
        bag.add(world);

        StringBuilder result = new StringBuilder();
        for (String s : bag) {
            result.append(s);
        }

        String expected = world + hello;
        assertEquals(expected, result.toString());
    }
}