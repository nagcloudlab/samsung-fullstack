package com.example.util;

import com.example.model.Product;

import java.util.Iterator;

// data-structure + iteration logic (iterator) => iterable

public class LinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;

    public void add(E data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }
    public void add(int index, E data) {
        Node node = new Node(data);
        if (index == 0) {
            node.setNext(head);
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }
    }
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (E) current.getData();
    }
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public E next() {
                E data = (E) current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}


