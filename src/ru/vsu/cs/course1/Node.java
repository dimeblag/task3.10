package ru.vsu.cs.course1;

public class Node<E> {
    Node<E> next;
    E obj;

    public Node(E val) {
        this.obj = val;
    }
}
