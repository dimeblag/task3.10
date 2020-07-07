package ru.vsu.cs.course1;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Node<E> head;
    private int size = 0;
    public MyStack() {}

    public E peek() {
        if(empty())
            throw new EmptyStackException();
        return head.obj;
    }
    public E pop() {
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
    public void push(E object) {
        Node<E> n = new Node(object);
        if(size == 0)
            head = n;
        else {
            Node<E> temp = head;
            head = n;
            head.next = temp;
        }
        size++;
    }
    public int size() {
        return size;
    }
}
