package com.litianyu.basics.project1a;

public class ArrayDequeTest {

    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addLast("d");
        deque.addLast("e");
        deque.addFirst("f");
        deque.addLast("g");
        deque.addLast("h");
        deque.addLast("X");
        deque.addLast("Y");
        deque.addLast("Z");
        deque.printDeque();
        System.out.println(deque.size());
        System.out.println(deque.capacity());
        System.out.println("\n-----------------\n");

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.capacity());
        System.out.println("\n-----------------\n");

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.capacity());
        System.out.println("\n-----------------\n");

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.capacity());
        System.out.println("\n-----------------\n");

        System.out.println(deque.removeFirst());
    }
}
