package com.yangdq.java.algorithm.fouth.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private static class Node<T> {
        private T t;
        private Node<T> next;
    }

    private Node<T> head;
    private Node<T> tail;
    private int n;

    public Queue() {
        head = null;
        tail = null;
        n = 0;
    }

    public T peak() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue underflow");
        }
        return head.t;
    }

    public void enqueue(T t) {
        Node<T> old = tail;
        tail = new Node<>();
        tail.t = t;
        if (isEmpty()) {
            head = tail;
        } else {
            old.next = tail;
        }
        n++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue underflow");
        }
        Node<T> node = head;
        head = head.next;
        n--;
        if (isEmpty()) {
            tail = null;
        }
        return node.t;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(head);
    }

    private class LinkedIterator implements Iterator {
        private Node<T> current;

        public LinkedIterator(Node<T> current) {
            this.current = current;
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

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
