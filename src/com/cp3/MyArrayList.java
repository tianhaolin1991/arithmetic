package com.cp3;

import java.util.Iterator;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class MyArrayList<E> implements Iterable<E> {
    //基础容量
    private static final int DEFAULE_CAPACIEY = 10;
    private int size;
    private E[] items;

    public MyArrayList() {
        doClear();
    }

    private void doClear() {
        this.size = 0;
        ensureCapacity(DEFAULE_CAPACIEY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        E[] old = items;
        items = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimEoSize() {
        ensureCapacity(size());
    }

    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.items[index];
    }

    public void set(int index, E t) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.items[index] = t;
    }

    public boolean add(E t) {
        add(size(), t);
        return true;
    }

    public void add(int index, E t) {
        if (items.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = this.size; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = t;
        size++;
    }

    public E remove(int index) {
        E removeItem = items[index];
        for (int i = index; i < this.size; i++) {
            items[index] = items[index + 1];
        }
        items[size-1] = null;
        size--;
        return removeItem;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator<E> implements Iterator<E>{

        private int current;
        @Override
        public boolean hasNext() {
            return current < MyArrayList.this.size;
        }

        @Override
        public E next() {
            return (E) MyArrayList.this.items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    };
}
