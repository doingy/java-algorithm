package com.yangdq.java.algorithm.fouth.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Bag<T> implements Iterable<T> {

    private static class Node<T> {
        private T t;
        private Node<T> next;
    }

    private Node<T> first;
    private int n;

    public Bag() {
        first = null;
        n = 0;
    }

    public void add(T t) {
        Node<T> old = first;
        first = new Node<>();
        first.t = t;
        first.next = old;
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
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
