package com.yangdq.java.algorithm.fouth.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private static class Node<T> {
        private T t;
        private Node<T> next;
    }

    private Node<T> first;
    private int n;

    public Stack() {
        first = null;
        n = 0;
    }

    public void push(T t) {
        Node<T> node = new Node<>();
        node.t = t;
        node.next = first;
        first = node;
        n++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        T t = first.t;
        first = first.next;
        n--;
        return t;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.t;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator {
        private Node<T> current;

        public LinkedIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T t = current.t;
            current = current.next;

            return t;
        }
    }
}
