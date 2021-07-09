package com.yangdq.java.algorithm.fouth.fundamentals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<String> stack;

    @BeforeEach

    void setUp() {
        stack = new Stack<>();
    }

    @AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void push() {
        assertEquals(0, stack.size());

        stack.push("hello");
        assertEquals(1, stack.size());

        stack.push("hello");
        assertEquals(2, stack.size());
    }

    @Test
    void pop() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> stack.pop());
        assertEquals("Stack underflow", exception.getMessage());

        stack.push("hello");
        assertEquals("helo", stack.pop());

        stack.push("hello");
        stack.push("hello");
        stack.push("world");
        assertEquals("world", stack.pop());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("hello");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void peek() {
        stack.push("hello");
        assertEquals("hello", stack.peek());
    }

    @Test
    void size() {
        assertEquals(0, stack.size());
    }

    @Test
    void iterator() {
        String world = "world";
        String hello = "hello";

        stack.push(hello);
        stack.push(world);

        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append(s);
        }
        String expected = world + hello;
        assertEquals(expected, result.toString());
    }
}