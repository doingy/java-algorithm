package com.yangdq.java.algorithm.fouth.fundamentals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void peak() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> queue.peak());
        assertEquals("queue underflow", exception.getMessage());

        queue.enqueue("hello");
        assertEquals("hello", queue.peak());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue("hello");
        assertFalse(queue.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());

        queue.enqueue("hello");
        assertEquals(1, queue.size());

        queue.enqueue("hello");
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void iterator() {
        String hello = "hello";
        String world = "world";
        queue.enqueue(hello);
        queue.enqueue(hello);
        queue.enqueue(world);
        queue.enqueue(hello);

        StringBuilder result = new StringBuilder();
        for (String s : queue) {
            result.append(s);
        }

        String expected = hello + hello + world + hello;
        assertEquals(expected, result.toString());
    }
}