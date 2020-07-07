package ru.vsu.cs.course1;

import java.util.EmptyStackException;

public class MyQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    public MyQueue() {}

    public E peek() {
        if(empty())
            throw new EmptyStackException();
        return head.obj;
    }
    public E poll() {
        if(empty())
            throw new EmptyStackException();

        E obj = peek();
        head = head.next;
        size--;
        return obj;
    }
    public boolean empty() {
        return size == 0;
    }
    public void add(E object) {
        Node<E> n = new Node(object);
        if(empty())
            head = tail = n;
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
    public int size() {
        return size;
    }
}
