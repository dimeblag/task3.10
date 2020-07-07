package ru.vsu.cs.course1;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator(this.head);
    }

    private class MyLinkedListIterator implements Iterator<E> {
        private Node<E> shouldNext;

        public MyLinkedListIterator(Node start) {
            shouldNext = start;
        }
        public boolean hasNext() {
            return shouldNext != null;
        }
        public E next() {
            E val = shouldNext.obj;
            shouldNext = shouldNext.next;
            return val;
        }
    }
    public Iterator<E> MyLinkedListIterator() {
        return new MyLinkedListIterator(this.head);
    }
    public E get(int index) {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException();

        Node<E> current = head;
        for(int i = 0; i < index && current.next != null; i++)
            current = current.next;

        return current.obj;
    }
    public String print() {
        Node current = head;
        String s = "";
        s += "[ ";
        while(current != null) {
            s += current.obj + " ";
            current = current.next;
        }
        s += "]";
        return s;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToTail(E val) {
        Node<E> n = new Node(val);

        if(isEmpty())
            head = tail = n;
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
    public void addToHead(E val) {
        Node<E> n = new Node(val);

        if(isEmpty())
            head = tail = n;
        else {
            Node temp = head;
            head = n;
            head.next = temp;
        }
        size++;
    }
    public void delete(int index) {
        if(index >= size() || index < 0)
            throw new IndexOutOfBoundsException();

        Node current = head;

        if(index == 0) {
            head = head.next;
        } else if (index < size() - 1){
            for (int i = 0; i < index; i++)
                current = current.next;
            current.next = current.next.next;
        } else {
            for(int i = 0; i < index - 1; i++)
                current = current.next;
            current.next = null;
        }
        size--;
    }
}
