package com.litianyu.basics.project1a;


/**
 * doubled linked list implemented with array
 */
public class ArrayDeque<T> implements Deque<T> {

    private int capacity;
    private Object[] carray; // 循环队列的好处是头插和尾插都不需要移动元素，只有扩容的时候才需要
    private int size;
    private int nextFirst;
    private int nextLast;


    /**;
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        this.capacity = 8;
        this.carray = new Object[this.capacity];
        this.size = 0;
        this.nextFirst = this.capacity / 2;
        this.nextLast = this.nextFirst + 1;
    }

    @Override
    public void addFirst(T item) {
        increaseCapacity();
        this.carray[this.nextFirst] = item;
        this.nextFirst = (this.nextFirst - 1 + this.capacity) % this.capacity;
        this.size++;
    }

    @Override
    public void addLast(T item) {
        increaseCapacity();
        this.carray[this.nextLast] = item;
        this.nextLast = (this.nextLast + 1) % this.capacity;
        this.size++;
    }

    private void increaseCapacity() {
        if (this.size == this.capacity) { // or size == capacity
            Object[] larger = new Object[this.capacity * 2];
            int tmp = (this.nextFirst + 1) % this.capacity;
            for (int i = 0; i < this.size; i++) {
                larger[i] = this.carray[tmp];
                tmp = (tmp + 1) % this.capacity;
            }
            this.capacity *= 2;
            this.carray = larger;
            this.nextFirst = this.capacity - 1;
            this.nextLast = this.size;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    @Override
    public void printDeque() {
        // 队头位置就是 nextFirst 的后一个索引
        for (int i = (this.nextFirst + 1) % this.capacity; i < this.nextLast; i = (i + 1) % this.capacity) {
            if (i != (this.nextFirst + 1) % this.capacity) {
                System.out.print(" ");
            }
            System.out.printf("%s", this.carray[i]);
        }
        System.out.print("\n");
    }

    @Override
    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        this.nextFirst = (this.nextFirst + 1 ) % this.capacity;
        T rm = (T) this.carray[this.nextFirst];
        this.size--;
        shrinkCapacity();
        return rm;
    }

    @Override
    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        this.nextLast = (this.nextLast - 1 + this.capacity) % this.capacity;
        T rm = (T) this.carray[this.nextLast];
        this.size--;
        shrinkCapacity();
        return rm;
    }

    private void shrinkCapacity() {
        if (this.capacity >= 16 && this.size < this.capacity / 4) {
            Object[] smaller = new Object[this.capacity/2];
            int tmp = (this.nextFirst + 1) % this.capacity;
            for (int i = 0; tmp != this.nextLast; i++) {
                smaller[i] = this.carray[tmp];
                tmp = (tmp + 1) % this.capacity;
            }
            this.capacity /= 2;
            this.carray = smaller;
            this.nextFirst = this.capacity - 1;
            this.nextLast = this.size;
        }
    }

    @Override
    public T get(int index) {
        if (index >= this.size || index < 0) {
            return null;
        }
        return (T) this.carray[(this.nextFirst + 1 + index) % this.capacity];
    }
}
